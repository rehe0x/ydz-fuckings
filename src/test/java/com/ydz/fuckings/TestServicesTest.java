//package com.ydz.fuckings;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.ydz.fuckings.business.mapper.AreaMapper;
//import com.ydz.fuckings.common.MyException;
//import com.ydz.fuckings.common.PadUtil;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class TestServicesTest {
//	
//	@Autowired
//	private AreaMapper areaMapper;
//	
//	@Test
//    public void test() {
//		try {
//			//System.out.println(PadUtil.PrefixInteger(224, 4));  
//			List<Map> listMap = areaMapper.findAll();
//			StringBuffer str= new StringBuffer("[");
//			int i=100;
//			for(Map map:listMap){
////				if(i==1){
////					break;
////				}
//				int id = (int) map.get("id");
//				int pid = (int) map.get("pid");
//				int level = (int) map.get("level");
//				String shortname =map.get("shortname").toString();
//				if(level==1){
//					str.append("'"+PadUtil.PrefixInteger(id, 4)+"00000000:"+shortname+"'");
//				}else if(level==2){
//					str.append("'"+PadUtil.PrefixInteger(pid, 4)+PadUtil.PrefixInteger(id, 4)+"0000:"+shortname+"'");
//				}else if(level==3){
//					Map maps  = areaMapper.findOne(pid);
//					str.append("'"+PadUtil.PrefixInteger((int) maps.get("pid"), 4)+PadUtil.PrefixInteger(pid, 4)+PadUtil.PrefixInteger(id, 4)+":"+shortname+"'");
//				}
//				str.append(",");
//			//	i--;
//			}
//			str.append("]");
//			
//			FileWriter fw = null;
//			File f=new File("G:\\workspase\\ydz-fuckings\\src\\main\\resources\\templates\\apps\\js\\jquery.ganged.data.js");
//			fw = new FileWriter(f, true);
//		
//			PrintWriter pw = new PrintWriter(fw);
//			pw.println("var data="+str);
//			pw.flush();
//			fw.flush();
//			pw.close();
//			fw.close();
//			System.out.println(str);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }
//}
