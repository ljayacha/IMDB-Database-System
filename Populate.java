import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.HashSet;

public class Populate
{ 
	public static void main(String[] args) throws SQLException, IOException {

		Populate ob =  new Populate();
		ob.PopulateMovie();
		ob.PopulateMovieTag();
		ob.PopulateTag();
		ob.PopulateConLoc();

	}
	public void PopulateMovie() throws SQLException {

		 String url = "jdbc:oracle:thin:@localhost:1521:books"; 
	     String user = "system"; 
	     String pass = "#######"; 

	     PreparedStatement preparedStmt = null;
	     DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
	     Connection con = DriverManager.getConnection(url,user,pass);
	try{
	    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\SCU\\DBMS\\Assignment\\assignment3\\movies.dat")); 
	    BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\SCU\\DBMS\\Assignment\\assignment3\\movie_genres.dat")); 
	    in.readLine();
	    String read =null;
	    while ((read = in.readLine()) != null) {
	        String[] eachline = read.split("\\t");
	        String movieid = eachline[0];      
	        String title= eachline[1]; 
	        String imdbID= eachline[2]; 
	        eachline[7]= eachline[7].replaceAll("[^\\d.]", "");
	        if (eachline[7].isEmpty()) {eachline[7] = "0";}
	        eachline[8]= eachline[8].replaceAll("[^\\d.]", "");
	        if (eachline[8].isEmpty()) {eachline[8] = "0";}
	        eachline[12]= eachline[12].replaceAll("[^\\d.]", "");
	        if (eachline[12].isEmpty()) {eachline[12] = "0";}
	        eachline[13]= eachline[13].replaceAll("[^\\d.]", "");
	        if (eachline[13].isEmpty()) {eachline[13] = "0";}
	        eachline[17]= eachline[17].replaceAll("[^\\d.]", "");
	        if (eachline[17].isEmpty()) {eachline[17] = "0";}
	        eachline[18]= eachline[18].replaceAll("[^\\d.]", "");
	        if (eachline[18].isEmpty()) {eachline[18] = "0";}
	        double allCriticsRating = Double.parseDouble(eachline[7]); 
	        double allCriticsNumReviews= Double.parseDouble(eachline[8]);
	        double rtTopCriticsRating = Double.parseDouble(eachline[12]); 
	        double rtTopCriticsNumReviews = Double.parseDouble(eachline[13]); 
	        double rtAudienceRating =Double.parseDouble(eachline[17]); 
	        double rtAudienceNumRatings=Double.parseDouble(eachline[18]); 
	        int year= Integer.parseInt(eachline[5]);
	        addmovievalue(con, preparedStmt, movieid,title,imdbID,allCriticsRating,allCriticsNumReviews,rtTopCriticsRating,rtTopCriticsNumReviews,rtAudienceRating,rtAudienceNumRatings,year);
	        System.out.println("inserted successfully");
	    }
	    in1.readLine();
	    String read1 =null;
	    while ((read1 = in1.readLine()) != null) {
	        String[] eachline = read1.split("\\t");
	        String movieid = eachline[0];
	        String genre = eachline[1];
	        addmoviegenrevalue(con, preparedStmt, movieid,genre);
	        System.out.println("inserted successfully");
	    }
	    con.close();
	}
	catch (IOException e) {System.out.println("There was a problem: " + e);}
	    if (con != null)
	    try{con.close();} catch(SQLException ignore){}     
	}
	
	public static void addmoviegenrevalue(Connection connection, PreparedStatement preparedstatement, String movieid,String genre) throws SQLException{
		preparedstatement=connection.prepareStatement("INSERT INTO MOVIES_GEN (movieid,genre) VALUES (?, ?)"); 
		preparedstatement.setString(1, movieid);
		preparedstatement.setString(2, genre);
		preparedstatement.executeUpdate();
		preparedstatement.close();
	}
	public static void addmovievalue(Connection connection, PreparedStatement preparedstatement, String movieid,String title,String imdbID,double allCriticsRating,double allCriticsNumReviews,double rtTopCriticsRating,double rtTopCriticsNumReviews,double rtAudienceRating,double rtAudienceNumRatings,int year) throws SQLException{
		preparedstatement=connection.prepareStatement("INSERT INTO MOVIES (movieid,title,imdbID,allCriticsRating,allCriticsNumReviews,rtTopCriticsRating,rtTopCriticsNumReviews,rtAudienceRating,rtAudienceNumRatings,year) VALUES (?, ?, ?, ?, ?,? ,? ,? ,?, ?)"); 
		preparedstatement.setString(1, movieid);
		preparedstatement.setString(2, title);
		preparedstatement.setString(3, imdbID);
		preparedstatement.setDouble(4,allCriticsRating);
		preparedstatement.setDouble(5,allCriticsNumReviews);
		preparedstatement.setDouble(6,rtTopCriticsRating);
		preparedstatement.setDouble(7,rtTopCriticsNumReviews);
		preparedstatement.setDouble(8,rtAudienceRating);
		preparedstatement.setDouble(9,rtAudienceNumRatings);
		preparedstatement.setInt(10, year);
		preparedstatement.executeUpdate();
		preparedstatement.close();
	}
	
	public void PopulateMovieTag() throws IOException, SQLException {

		 String url = "jdbc:oracle:thin:@localhost:1521:books"; 
	     String user = "system"; 
	     String pass = "#######"; 

	     PreparedStatement preparedStmt = null;
	     DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
	     Connection con = DriverManager.getConnection(url,user,pass);
	try{
	    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\SCU\\DBMS\\Assignment\\assignment3\\movie_tags.dat")); 
	    in.readLine();
	    String read =null;
	    while ((read = in.readLine()) != null) {
	        String[] eachline = read.split("\\t");
	        String id = eachline[0];      
	        String tag_id= eachline[1]; 
	        int tag_weight= Integer.parseInt(eachline[2]); 
	        addtagvalue(con, preparedStmt, id, tag_id,tag_weight);
	        System.out.println("inserted successfully");
	    }
	    con.close();
	}
	catch (IOException e) {System.out.println("There was a problem: " + e);}
	    if (con != null)
	    try{con.close();} catch(SQLException ignore){} 
	}
		public static void addtagvalue(Connection connection, PreparedStatement preparedstatement, String id, String tag_id, int tag_weight) throws SQLException{
			preparedstatement=connection.prepareStatement("INSERT INTO MOVIE_TAG_VALUES (id,tag_id,tag_weight) VALUES (?, ?, ?)"); 
			preparedstatement.setString(1, id);
			preparedstatement.setString(2, tag_id);
			preparedstatement.setInt(3, tag_weight);
			preparedstatement.executeUpdate();
			preparedstatement.close();
		}
		public  void PopulateTag() throws IOException, SQLException {

			 String url = "jdbc:oracle:thin:@localhost:1521:books"; 
		     String user = "system"; 
		     String pass = "#######"; 

		     PreparedStatement preparedStmt = null;
		     DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
		     Connection con = DriverManager.getConnection(url,user,pass);
		try{
		    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\SCU\\DBMS\\Assignment\\assignment3\\tags.dat")); 
		    in.readLine();
		    String read =null;
		    while ((read = in.readLine()) != null) {
		        String[] eachline = read.split("\\t");
		        String id = eachline[0];      
		        String tag_value= eachline[1];     
		        addtagvalue(con, preparedStmt, id, tag_value);
		        System.out.println("inserted successfully");
		    }
		    con.close();
		}
		catch (IOException e) {System.out.println("There was a problem: " + e);}
		    if (con != null)
		    try{con.close();} catch(SQLException ignore){} 
		}
			public static void addtagvalue(Connection connection, PreparedStatement preparedstatement, String id, String tag_value) throws SQLException{
				preparedstatement=connection.prepareStatement("INSERT INTO TAG_VALUES (id,tag_value) VALUES (?, ?)"); 
				preparedstatement.setString(1, id);
				preparedstatement.setString(2, tag_value);
				preparedstatement.executeUpdate();
				preparedstatement.close();
			}	
			
			public void PopulateConLoc() throws IOException, SQLException {

				 String url = "jdbc:oracle:thin:@localhost:1521:books"; 
			     String user = "system"; 
			     String pass = "#######"; 

			     PreparedStatement preparedStmt = null;
			     DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			     Connection con = DriverManager.getConnection(url,user,pass);
			try{
			    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\SCU\\DBMS\\Assignment\\assignment3\\movie_countries.dat")); 
			    BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\SCU\\DBMS\\Assignment\\assignment3\\movie_locations.dat")); 
			    in.readLine();
			    String read =null;
			    while ((read = in.readLine()) != null) {
			        String[] eachline = read.split("\\t");
			        String movieid = null;
					String country = null;
			        if(eachline.length < 2) {
			        	 movieid = eachline[0];  
			             country = null;
			        }else {
			        	 movieid = eachline[0];  
			             country = eachline[1]; 
			        } 
			        addcountryvalue(con, preparedStmt, country,movieid);
			        System.out.println("inserted successfully");
			    }
			    in1.readLine();
			    String read1 =null;
			    String location = null;
			    while ((read1 = in1.readLine()) != null) {
			        String[] eachline = read1.split("\t");
			        String movieid = null;
			        if(eachline.length < 2) {
			        	 movieid = eachline[0];  
			             location = null;
			        }else {
			        	movieid = eachline[0];  
			        	location =eachline[1];
			            addlocationvalue(con, preparedStmt,movieid,location);
			            System.out.println("inserted successfully");
			        	
			        } 
			    }
			    con.close();
			}
			catch (IOException e) {System.out.println("There was a problem: " + e);}
			    if (con != null)
			    try{con.close();} catch(SQLException ignore){} 
			}
				public static void addcountryvalue(Connection connection, PreparedStatement preparedstatement, String country,String movieid) throws SQLException{
					preparedstatement=connection.prepareStatement("UPDATE MOVIES SET country = (?) WHERE movieid = (?)"); 
					preparedstatement.setString(1, country);
					preparedstatement.setString(2, movieid);
					preparedstatement.executeUpdate();
					preparedstatement.close();
				}
				public static void addlocationvalue(Connection connection, PreparedStatement preparedstatement, String movieid,String location) throws SQLException{
					preparedstatement=connection.prepareStatement("INSERT INTO MOVIES_LOC (movieid,location) VALUES (?, ?)"); 
					preparedstatement.setString(1, movieid);
					preparedstatement.setString(2, location);
					preparedstatement.executeUpdate();
					preparedstatement.close();
				}
}