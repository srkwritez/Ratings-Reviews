package com.srkwritez;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyDomParser 
{
	public static void main(String[] args) {
		System.out.println("Parser Begins");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//System.out.println("Break Point 2");
			DocumentBuilder builder =factory.newDocumentBuilder();
			Document doc= builder.parse("BV_Response.xml ");
			NodeList reviewList = doc.getElementsByTagName("Review");
			//System.out.println("Break Pint 3");
			
//			Iterating through ratingList for each rating
			System.out.println("Test");
			for(int i=0;i<reviewList.getLength();i++)
			{
				Node reviewNode = reviewList.item(i);
				if(reviewNode.getNodeType()==Node.ELEMENT_NODE)
				{
					//System.out.println(reviewNode.getNodeType()==Node.ELEMENT_NODE);
					Element review = (Element) reviewNode;
					String id = review.getAttribute("id");
					NodeList ratingList = review.getChildNodes();
					for(int j=0;j<ratingList.getLength();j++)
					{
						
						Node ratingNode = ratingList.item(j);
						
						if(ratingNode.getNodeType()==Node.ELEMENT_NODE)
						{
							
							Element rating = (Element) ratingNode;
							if(rating.getTagName()=="Rating" || rating.getTagName()=="UserNickname" || rating.getTagName()=="Title"|| rating.getTagName()=="ReviewText" )
							System.out.println("Review "+id+" : "+rating.getTagName()+" = "+rating.getTextContent());
						}
						
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
