package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Documents.*;
import Reseau.*;

public class FileReader 
{
	public static void getDataFromCSVFile(String csvFilePath,ArrayList<Bibliotheque> b,ArrayList<Document> d)
	{
        String line = "";
        String[] data = null;
        String separator = ";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        
        //Document data
        String isbn;
        String ean;
        String title;
        String publisher;
        String date;
        String seriesTitle;
        Integer seriesNumber;
        String authorName;
        String authorSurname;
        String type;
        int totalCopies;
        int numberCopyAimeCesaire;
        int numberCopyEdmondRostand;
        int numberCopyJeanPierreMelville;
        int numberCopyOscarWilde;
        int numberCopySaintSimon;
        
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(csvFilePath), StandardCharsets.ISO_8859_1)) 
        {
        	//Read the first line
        	line = bufferedReader.readLine();
        	
        	//Get data from the line
        	data = line.split(separator, -1);
        	
        	Bibliotheque b1 = new Bibliotheque("AimeCesaire","");
        	Bibliotheque b2 = new Bibliotheque("EdmondRostand","");
        	Bibliotheque b3 = new Bibliotheque("JeanPierreMelville","");
        	Bibliotheque b4 = new Bibliotheque("OscarWilde","");
        	Bibliotheque b5 = new Bibliotheque("SaintSimon","");
        	
        	
        	if(data.length != 16)
        	{
        		System.out.println("[FileReader] The file at " + csvFilePath + " does not contain the right number of columns.");
        		return;
        	}
        	
        	int i = 1;
        	
        	//Read the file line by line
            while ((line = bufferedReader.readLine()) != null)
            {
            	//Get data from the line
            	data = line.split(separator, -1);
            	
            	//Sort data
            		
            		//Get the ISBN number
            		isbn = data[0];
            		
            		//Get the EAN number
            		ean = data[1];
            		
            		//Get the title of the document
            		title = data[2];

            		//Get the name of the publisher
            		publisher = data[3];
            		
            		//Get the publication date
            		try
            		{
            			int dateInt = Integer.parseInt(data[4].replaceAll("[^0-9]", ""));
            			
            			if(dateInt%10000 >= 2021 || dateInt%10000 < 0)
            			{
            				date = "?";
            			}
            			else if(dateInt/10000 == 0)
            			{
            				date = Integer.toString(dateInt%10000);
            			}
            			else
            			{
            				date = dateInt%10000 + "-" + dateInt/10000;
            			}
            		}
            		catch (Exception exception)
            		{
            			date = "?";
            		}
            		
            		//Get the title of the series
            		seriesTitle = data[5];
            		
            		//Get the number of this document in the series
            		try
            		{
            			seriesNumber = Integer.parseInt(data[6]);
            		}
            		catch (Exception exception)
            		{
            			seriesNumber = null;
            		}
            		
            		//Get the name of the author
            		authorSurname = data[7];
            		
            		//Get the surname of the author
            		authorName = data[8];
            		
            		//Get the type of the document
            		type = data[9];
            		
            		//Get the total number of copy in Paris for this document 
            		try
            		{
            			totalCopies = Integer.parseInt(data[10]);
            		}
            		catch (Exception exception)
            		{
            			totalCopies = 0;
            		}
            		
            		//Get the number of copy in the library "Aime Cesaire"
            		try
            		{
            			numberCopyAimeCesaire = Integer.parseInt(data[11]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyAimeCesaire = 0;
            		}
            		
            		//Get the number of copy in the library "Edmond Rostand"
            		try
            		{
            			numberCopyEdmondRostand = Integer.parseInt(data[12]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyEdmondRostand = 0;
            		}
            		
            		//Get the number of copy in the library "Jean-Pierre Melville"
            		try
            		{
            			numberCopyJeanPierreMelville = Integer.parseInt(data[13]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyJeanPierreMelville = 0;
            		}
            		
            		//Get the number of copy in the library "Oscar Wilde"
            		try
            		{
            			numberCopyOscarWilde = Integer.parseInt(data[14]);
            		}
            		catch (Exception exception)
            		{
            			numberCopyOscarWilde = 0;
            		}
            		
            		//Get the number of copy in the library "Saint-Simon"
            		try
            		{
            			numberCopySaintSimon = Integer.parseInt(data[15]);
            		}
            		catch (Exception exception)
            		{
            			numberCopySaintSimon = 0;
            		}
                
                //TODO Do something with data
            	
            		//parserType
            		
            		if(type.contains("Livre"))
            			type="Livre";
            		else {
            			if(type.contains("Bande dessinee"))
                			type="BD";
            			else {
            				if(type.contains("Partition"))
                    			type="Partition"; 
            				else {
                				if(type.contains("Disque compact"))
                        			type="CD";
                				else {
                    				if(type.contains("Carte"))
                            			type="Carte";
                    				else {
                        				if(type.contains("Revue"))
                                			type="Revue";
                        				else {
                            				if(type.contains("Vinyle"))
                                    			type="Vinyle";
                            				else {
                                				if(type.contains("Jeux de societe"))
                                        			type="JeuxSociete";
                                				else {
                                    				if(type.contains("Jeux Video"))
                                            			type="JeuxVideo";
                                    			}
                                			}
                            			}
                        			}
                    			}
                			}        				
            			}
            		}
            			
            		
            		switch(type) {
            		case "Livre":
            			System.out.println("Livre");
            			Livre l = new Livre(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title),isbn);
            			d.add(l);
            			if(numberCopyAimeCesaire>0) {
            				System.out.println("1");
            				b1.ajouterDocument(l, numberCopyAimeCesaire);
            			}
            			if(numberCopyEdmondRostand>0) {
            				b2.ajouterDocument(l, numberCopyEdmondRostand);
            				System.out.println("2");
            			}
            			if(numberCopyJeanPierreMelville>0) {
            				b3.ajouterDocument(l, numberCopyJeanPierreMelville);
            				System.out.println("3");
            			}
            			if(numberCopyOscarWilde>0) {
            				b4.ajouterDocument(l, numberCopyOscarWilde);
            				System.out.println("4");
            			}
            			if(numberCopySaintSimon>0) {
            				b5.ajouterDocument(l, numberCopySaintSimon);
            				System.out.println("5");
            			}
            			break;
            		case "BD":
            			System.out.println("BD");
            			BD bd = new BD(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title),isbn);
            			d.add(bd);
            			if(numberCopyAimeCesaire>0) {
            				b1.ajouterDocument(bd, numberCopyAimeCesaire);
            			}
            			if(numberCopyEdmondRostand>0) {
            				b2.ajouterDocument(bd, numberCopyEdmondRostand);
            			}
            			if(numberCopyJeanPierreMelville>0) {
            				b3.ajouterDocument(bd, numberCopyJeanPierreMelville);
            			}
            			if(numberCopyOscarWilde>0) {
            				b4.ajouterDocument(bd, numberCopyOscarWilde);
            			}
            			if(numberCopySaintSimon>0) {
            				b5.ajouterDocument(bd, numberCopySaintSimon);
            			}
            			break;	
            		case "Partition":
            			System.out.println("Part");
            			Partition partition = new Partition(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title),isbn);
            			d.add(partition);
            			if(numberCopyAimeCesaire>0) {
            				b1.ajouterDocument(partition, numberCopyAimeCesaire);
            			}
            			if(numberCopyEdmondRostand>0) {
            				b2.ajouterDocument(partition, numberCopyEdmondRostand);
            			}
            			if(numberCopyJeanPierreMelville>0) {
            				b3.ajouterDocument(partition, numberCopyJeanPierreMelville);
            			}
            			if(numberCopyOscarWilde>0) {
            				b4.ajouterDocument(partition, numberCopyOscarWilde);
            			}
            			if(numberCopySaintSimon>0) {
            				b5.ajouterDocument(partition, numberCopySaintSimon);
            			}
            			break;	
            		case "CD":
            			System.out.println("Cd");
            			CD cd = new CD(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title));
            			d.add(cd);
            			if(numberCopyAimeCesaire>0) {
            				b1.ajouterDocument(cd, numberCopyAimeCesaire);
            			}
            			if(numberCopyEdmondRostand>0) {
            				b2.ajouterDocument(cd, numberCopyEdmondRostand);
            			}
            			if(numberCopyJeanPierreMelville>0) {
            				b3.ajouterDocument(cd, numberCopyJeanPierreMelville);
            			}
            			if(numberCopyOscarWilde>0) {
            				b4.ajouterDocument(cd, numberCopyOscarWilde);
            			}
            			if(numberCopySaintSimon>0) {
            				b5.ajouterDocument(cd, numberCopySaintSimon);
            			}
            			break;	
            		case "Carte":
            			System.out.println("Carte");
            			Carte carte = new Carte(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title),isbn);
            			d.add(carte);
            			if(numberCopyAimeCesaire>0) {
            				b1.ajouterDocument(carte, numberCopyAimeCesaire);
            			}
            			if(numberCopyEdmondRostand>0) {
            				b2.ajouterDocument(carte, numberCopyEdmondRostand);
            			}
            			if(numberCopyJeanPierreMelville>0) {
            				b3.ajouterDocument(carte, numberCopyJeanPierreMelville);
            			}
            			if(numberCopyOscarWilde>0) {
            				b4.ajouterDocument(carte, numberCopyOscarWilde);
            			}
            			if(numberCopySaintSimon>0) {
            				b5.ajouterDocument(carte, numberCopySaintSimon);
            			}
            			break;	
            			case "Revue":
            				System.out.println("Revie");
            				Revue revue = new Revue(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title));
            				d.add(revue);
            				if(numberCopyAimeCesaire>0) {
            					b1.ajouterDocument(revue, numberCopyAimeCesaire);
            				}
            				if(numberCopyEdmondRostand>0) {
            					b2.ajouterDocument(revue, numberCopyEdmondRostand);
            				}
            				if(numberCopyJeanPierreMelville>0) {
            					b3.ajouterDocument(revue, numberCopyJeanPierreMelville);
            				}
            				if(numberCopyOscarWilde>0) {
            					b4.ajouterDocument(revue, numberCopyOscarWilde);
            				}
            				if(numberCopySaintSimon>0) {
            					b5.ajouterDocument(revue, numberCopySaintSimon);
            				}
            				break;	
            			case "Vinyle":
            				System.out.println("Vynyl");
            				Vinyle vinyle = new Vinyle(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title));
            				d.add(vinyle);
            				if(numberCopyAimeCesaire>0) {
            					b1.ajouterDocument(vinyle, numberCopyAimeCesaire);
            				}
            				if(numberCopyEdmondRostand>0) {
            					b2.ajouterDocument(vinyle, numberCopyEdmondRostand);
            				}
            				if(numberCopyJeanPierreMelville>0) {
            					b3.ajouterDocument(vinyle, numberCopyJeanPierreMelville);
            				}
            				if(numberCopyOscarWilde>0) {
            					b4.ajouterDocument(vinyle, numberCopyOscarWilde);
            				}
            				if(numberCopySaintSimon>0) {
            					b5.ajouterDocument(vinyle, numberCopySaintSimon);
            				}
            				break;	
            			case "JeuxSociete":
            				System.out.println("js");
            				JeuxSociete jeuxSociete = new JeuxSociete(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title));
            				d.add(jeuxSociete);
            				if(numberCopyAimeCesaire>0) {
            					b1.ajouterDocument(jeuxSociete, numberCopyAimeCesaire);
            				}
            				if(numberCopyEdmondRostand>0) {
            					b2.ajouterDocument(jeuxSociete, numberCopyEdmondRostand);
            				}
            				if(numberCopyJeanPierreMelville>0) {
            					b3.ajouterDocument(jeuxSociete, numberCopyJeanPierreMelville);
            				}
            				if(numberCopyOscarWilde>0) {
            					b4.ajouterDocument(jeuxSociete, numberCopyOscarWilde);
            				}
            				if(numberCopySaintSimon>0) {
            					b5.ajouterDocument(jeuxSociete, numberCopySaintSimon);
            				}
            				break;	
            			case "JeuxVideo":
            				System.out.println("jv");
            				JeuxVideo jeuxVideo = new JeuxVideo(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title));
            				d.add(jeuxVideo);
            				if(numberCopyAimeCesaire>0) {
            					b1.ajouterDocument(jeuxVideo, numberCopyAimeCesaire);
            				}
            				if(numberCopyEdmondRostand>0) {
            					b2.ajouterDocument(jeuxVideo, numberCopyEdmondRostand);
            				}
            				if(numberCopyJeanPierreMelville>0) {
            					b3.ajouterDocument(jeuxVideo, numberCopyJeanPierreMelville);
            				}
            				if(numberCopyOscarWilde>0) {
            					b4.ajouterDocument(jeuxVideo, numberCopyOscarWilde);
            				}
            				if(numberCopySaintSimon>0) {
            					b5.ajouterDocument(jeuxVideo, numberCopySaintSimon);
            				}
            				break;	
            			default:
            				System.out.println("Autre");
            				Autre autre = new Autre(title,publisher,authorName,authorSurname,ean,date,totalCopies,seriesNumber,new Serie(title));
            				d.add(autre);
            				if(numberCopyAimeCesaire>0) {
            					b1.ajouterDocument(autre, numberCopyAimeCesaire);
            				}
            				if(numberCopyEdmondRostand>0) {
            					b2.ajouterDocument(autre, numberCopyEdmondRostand);
            				}
            				if(numberCopyJeanPierreMelville>0) {
            					b3.ajouterDocument(autre, numberCopyJeanPierreMelville);
            				}
            				if(numberCopyOscarWilde>0) {
            					b4.ajouterDocument(autre, numberCopyOscarWilde);
            				}
            				if(numberCopySaintSimon>0) {
            					b5.ajouterDocument(autre, numberCopySaintSimon);
            				}
            				break;	
            		}
            		
            		
                /*System.out.println(
                		isbn + ";" +
                		ean + ";" +
                		title + ";" +
                		publisher + ";" +
                		date + ";" +
                		seriesTitle + ";" +
                		seriesNumber + ";" +
                		authorName + ";" +
                		authorSurname + ";" +
                		type + ";" +
                		totalCopies + ";" +
                		numberCopyAimeCesaire + ";" +
                		numberCopyEdmondRostand + ";" +
                		numberCopyJeanPierreMelville + ";" +
                		numberCopyOscarWilde + ";" +
                		numberCopySaintSimon);*/
            }
            b.add(b1);
            b.add(b2);
            b.add(b3);
            b.add(b4);
            b.add(b5);
        } 
        catch (IOException exception) 
        {
            System.err.println(exception);
        }
	}
}