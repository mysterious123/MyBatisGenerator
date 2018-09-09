package cn.com.generator.main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmMap {
	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		GeneratorSqlmMap  generatorSqlmMap =new GeneratorSqlmMap();
		generatorSqlmMap.generator();
	}

	public  void generator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		 //warnings Ϊ�ڷ������ɹ����о�����Ϣ�ļ��϶���
         List<String> warnings =new ArrayList<String>();
         //ָ���Ƿ񸲸������ļ�
         boolean overwrite = true;
         //���������ļ�
         File configFile =new File("generatorConfig.xml");
         //���ý�����
         ConfigurationParser cp=new    ConfigurationParser( warnings);
         //���ý�������������ļ�������Configuration���ö���
         Configuration config =cp.parseConfiguration(configFile);
         //ShellCallBack������δ����ظ��ļ�
         ShellCallback callback =new DefaultShellCallback(overwrite);
         
         //���򹤳̶���
         MyBatisGenerator myBatisGenertor=new MyBatisGenerator(config, callback, warnings);
         //ִ�������ļ����ɲ���
         myBatisGenertor.generate(null);
         
	}

}
