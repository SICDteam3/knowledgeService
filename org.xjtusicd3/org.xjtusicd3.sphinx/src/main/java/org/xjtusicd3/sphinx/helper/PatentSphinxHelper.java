package org.xjtusicd3.sphinx.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xjtusicd3.database.model.PersistencePatent;
import org.xjtusicd3.sphinx.api.SphinxClient;
import org.xjtusicd3.sphinx.api.SphinxFactory;
import org.xjtusicd3.sphinx.api.SphinxMatch;
import org.xjtusicd3.sphinx.api.SphinxResult;

public class PatentSphinxHelper {
	
	
	//返回有多少行数据
	public static int getCount(String context) throws Exception {
		long start = System.currentTimeMillis();
		
		int count = 0;
		SphinxClient client = SphinxFactory.getClient();
		SetClient(client);
		//加一个查出总数的限制，限制查出的专利条数是100000条
		//client.SetLimits(0, 100000);
		SphinxResult result = client.Query(context, "patentIndex");
		count = result.totalFound;
		long end = System.currentTimeMillis();
		System.out.println("计总数的时间："+(end-start));
		return count;
	}
		

	//返回当前页的专利数据
	public static List<PersistencePatent> getPageList(int pageNo, int pageSize, String context) throws Exception {
		List<PersistencePatent> patents =  null;
		long start = System.currentTimeMillis();
		SphinxClient client = SphinxFactory.getClient();
		client.SetLimits(pageNo, pageSize);
		SetClient(client);
		SphinxResult result = client.Query(context, "patentIndex");
		long end = System.currentTimeMillis();
		System.out.println("查询时间："+(end-start));
		
		patents = convert2Persistence(result);
		long endConvert = System.currentTimeMillis();
		System.out.println("格式转化时间："+(endConvert-end));
		
		return patents;
	}
	
	private static void SetClient(SphinxClient cl) throws Exception {
		
		String host = "115.154.137.99";
		int port = 9312;
		int mode = SphinxClient.SPH_MATCH_ANY;
		
		int sortMode = SphinxClient.SPH_SORT_RELEVANCE;
		String sortClause = "";	
		cl.SetServer ( host, port );
		cl.SetWeights ( new int[] { 100, 1 } );
		cl.SetMatchMode ( mode );
		cl.SetSortMode ( sortMode, sortClause );
		
	}

	private static List<PersistencePatent> convert2Persistence(SphinxResult res) {
		List<PersistencePatent> listpatent = new ArrayList<PersistencePatent>(); 
		
		for ( int i=0; i<res.matches.length; i++ )
		{
			
			PersistencePatent tempPatent = new PersistencePatent();
			SphinxMatch info = res.matches[i];
			System.out.print ( (i+1) + ". id=" + info.docId + ", weight=" + info.weight );
			//设置专利id
			tempPatent.setPatentId((int) info.docId);
			
			if ( res.attrNames==null || res.attrTypes==null )
				continue;
//数据转化成PersistencePatent
			for ( int a=0; a<res.attrNames.length; a++ )
			{
				switch (res.attrNames[a]) {
					case "name":tempPatent.setName((String) info.attrValues.get(a));
					case "number":tempPatent.setNumber((String) info.attrValues.get(a));
					case "patent_inventor":tempPatent.setPatent_inventor((String) info.attrValues.get(a));
					case "patent_holder":tempPatent.setPatent_holder((String) info.attrValues.get(a));
					case "date_of_application":tempPatent.setDate_of_application((String) info.attrValues.get(a));
					case "announcement_date":tempPatent.setAnnouncement_date((String) info.attrValues.get(a));
					case "patent_abstract":tempPatent.setPatent_abstract((String) info.attrValues.get(a));
					case "ipc":tempPatent.setIPC((String) info.attrValues.get(a));
					case "type":tempPatent.setType((String) info.attrValues.get(a));
					case "address":tempPatent.setAddress((String) info.attrValues.get(a));
					case "principal_claim":tempPatent.setPrincipal_claim((String) info.attrValues.get(a));
					break;

				default:
					break;
				}
				//打印专利列表
				System.out.print ( ", " + res.attrNames[a] + "=" );
				switch ( res.attrTypes[a] )
					{
						case SphinxClient.SPH_ATTR_INTEGER:
						case SphinxClient.SPH_ATTR_ORDINAL:
						case SphinxClient.SPH_ATTR_FLOAT:
						case SphinxClient.SPH_ATTR_BIGINT:
						case SphinxClient.SPH_ATTR_STRING:
							/* ints, longs, floats, strings.. print as is */
							System.out.print ( info.attrValues.get(a) );
							break;

						case SphinxClient.SPH_ATTR_TIMESTAMP:
							Long iStamp = (Long) info.attrValues.get(a);
							Date date = new Date ( iStamp.longValue()*1000 );
							System.out.print ( date.toString() );
							break;

						default:
							System.out.print ( "(unknown-attr-type=" + res.attrTypes[a] + ")" );
				}

		 }
			System.out.println();
			listpatent.add(tempPatent);
	 }
		return listpatent;
	}
	
}
