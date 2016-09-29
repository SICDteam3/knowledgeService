package org.xjtusicd3.portal.service;
import java.util.ArrayList;
import org.xjtusicd3.database.helper.LogHelper;
import org.xjtusicd3.database.helper.PatentHelper;

public class SystemStateService {
    /*
     *专利爬去趋势 
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList patentUpdateCount(int time){
		ArrayList count=new ArrayList();
		PatentHelper ph=new PatentHelper();
		/*
		 * 判断是想要一周、一个月还是六个月的专利爬取记录
		 * */
		if(time==1){

			/*
			 *获取7天前的时间戳 
			 */
			  long time2=System.currentTimeMillis() - (1000 * 60 * 60 * 24 *7);
			  for(int i=7;i>=1;i--){
				  time2=System.currentTimeMillis() - (1000 * 60 * 60 * 24 *i);
			      count.add(ph.count(time2));
			   }
	          }
		else if(time==2){
			/*
			 *获取一个月前的时间戳 
			 */
			  long time2=System.currentTimeMillis() - (1000 * 60 * 60 * 24 *30);
			  for(int i=30;i<=1;i-=7){
				  time2=System.currentTimeMillis() - (1000 * 60 * 60 * 24 *i);
			      count.add(ph.count(time2));
			   }
		}
		else{
			/*
			 *获取6个月的时间戳 
			 */
			  long time2=System.currentTimeMillis() - (1000 * 60 * 60 * 24 *180);
			  for(int i=180;i<=1;i-=30){
				  time2=System.currentTimeMillis() - (1000 * 60 * 60 * 24 *i);
			      count.add(ph.count(time2));
			   }
		}
		return count;
       }
   /*
   * 在线人数变化
   * @return num1 日变化、num2 周变化
   * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<?> loginCount() {
		ArrayList num=new ArrayList();
		ArrayList num1=new ArrayList();
		ArrayList num2=new ArrayList();
		LogHelper lh=new LogHelper();
		  for(int i=12;i>=1;i-=2){
			  long time3=System.currentTimeMillis() - (1000 * 60 * 60  *i);
		      num1.add(lh.loginCount(time3));
		   }
		  for(int i=30;i>=1;i--){
			  long time3=System.currentTimeMillis() - (1000 * 60 * 60 * 24 *i);
		      num2.add(lh.loginCount(time3));
		   }
		  num.add(num1);
		  num.add(num2);
		return num;
	}
  }
