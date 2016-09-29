package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="log")
public class PersistenceLog {

		@TableKey(strategy = Strategy.NORMAL)
		
		@TableField(columnName="logId")
		private int logId;
		
		@TableField(columnName="ip")
		private String ip;
		
		@TableField(columnName="userName")
		private String userName;
		
		@TableField(columnName="operation")
		private String operation;
		
		@TableField(columnName="argument")
		private String argument;
		
		@TableField(columnName="time")
		private String time;

		public int getLogId() {
			return logId;
		}

		public void setLogId(int logId) {
			this.logId = logId;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

		public String getArgument() {
			return argument;
		}

		public void setArgument(String argument) {
			this.argument = argument;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}
		
}
