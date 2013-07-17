package com.friends.charity.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import com.friends.charity.business.service.GeneralService;
import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.admin.about.Qustion;

public class Main {  
	public static void main(String[] args) throws UnsupportedEncodingException {
//		/*    */ import java.util.List;
//		/*    */ import javax.faces.model.ListDataModel;
//		/*    */ import org.primefaces.model.SelectableDataModel;
//		/*    */ 
//		/*    */ public class DataModel<T> extends ListDataModel<T>
//		/*    */   implements SelectableDataModel<T>
//		/*    */ {
//		/*    */   public T getRowData(String rowKey)
//		/*    */   {
//		/* 16 */     for (Object t : (List)getWrappedData()) {
//		/* 17 */       if (String.valueOf(getId(t.getClass(), t)).equals(rowKey)) {
//		/* 18 */         return t;
//		/*    */       }
//		/*    */     }
//		/* 21 */     return null;
//		/*    */   }
//		/*    */ 
//		/*    */   public Object getRowKey(T t)
//		/*    */   {
//		/* 26 */     return Long.valueOf(getId(t.getClass(), t));
//		/*    */   }
//		/*    */ 
//		/*    */   private long getId(Class<?> clas, T t) {
//		/* 30 */     Field[] fields = clas.getDeclaredFields();
//		/* 31 */     label135: for (Field field : fields) {
//		/* 32 */       field.setAccessible(true);
//		/* 33 */       if (!(field.getName().equalsIgnoreCase("id"))) continue;
//		/*    */       try {
//		/* 35 */         if (field.getType() == Long.TYPE)
//		/* 36 */           return field.getLong(t);
//		/* 37 */         if (field.getType() == Long.class)
//		/* 38 */           return ((Number)field.get(t)).longValue();
//		/* 39 */         if (field.getType() == Integer.TYPE)
//		/* 40 */           return field.getInt(t);
//		/* 41 */         if (field.getType() != Integer.class) break label135;
//		/* 42 */         return ((Number)field.get(t)).intValue();
//		/*    */       }
//		/*    */       catch (java.lang.IllegalArgumentException e) {
//		/* 45 */         e.printStackTrace();
//		/*    */       }
//		/*    */     }
//		/*    */ 
//		/* 49 */     if (clas.getSuperclass() != Object.class) {
//		/* 50 */       return getId(clas.getSuperclass(), t);
//		/*    */     }
//		/* 52 */     return 0L;
//		/*    */   }
//		/*    */ }			
	}
}
