package com.ljs.dsctest.dsctestjobwebdatapreprocessing;

import com.ljs.dsctest.dsctestjobwebdatapreprocessing.XMLToCSV.conf.xmlcsvConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DsctestJobWebDataPreprocessingApplicationTests {

	//测试过程：
//	@Autowired
	private xmlcsvConfig document;

	@Test
	public void readXMLJiegou() throws Exception{
		ArrayList<String> destinct =document.ReadCSV();
		Iterator iter = destinct.iterator();
		while(iter.hasNext()){
			String tmp= (String) iter.next();
			System.out.println(tmp);
		}
		System.out.println("1");
	}

}
