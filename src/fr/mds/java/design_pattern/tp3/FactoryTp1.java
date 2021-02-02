package fr.mds.java.design_pattern.tp3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.mds.java.design_pattern.tp3.utils.ClassUtils;

/**
*
* @author tactfactory
*
* - Modifier le programme pour permettre de créer des Building au travers d'un design pattern "Factory" :
*   - 1 : Il existe 3 façon de créer des Building
*     - 1 : Créer aléatoirement pour toutes les classes du package courant qui implémente "Building", qui possède un
*         constructeur vide, qui sont publiques et qui ne sont pas abstraites
*     - 2 : Créer depuis une chaine de caractère qui représente le "simpleName" de la classe à utiliser qui implémente
*         "Building", qui possède un constructeur vide, qui est publique et qui n'est pas abstraite
*     - 3 : Depuis une classe qui implémente "Building", qui possède un constructeur vide, qui est publique et qui
*         n'est pas abstraite
*   - 2 : Créer deux listes de building dans le point d'entré de l'application
*     - 1 : La première liste doit contenir 20 Building généré aléatoirement
*     - 2 : La deuxième doit contenir au moins une fois chaque classe qui implémente "Building", qui possède un
*         constructeur vide, qui sont publiques et qui ne sont pas abstraites. En utilisant soit les chaine de
*         caractères ou les classes
*/
public class FactoryTp1 {

  public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
	List<Building> list1 = randomTown();
    System.out.println("---------------------------");
    List<Building> list2 = manualTown();
  }

  public static List<Building> manualTown() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	  List<Building> buildings = new ArrayList<>();
	  
	  for (Class<?> klazz :  ClassUtils.getClasses("fr.mds.java.design_pattern.tp3")) {
			  if(klazz.getInterfaces().length > 0 && klazz.getInterfaces()[0].getName().equals(Building.class.getName())) {
				  buildings.add((Building) klazz.getConstructor().newInstance());
			  }		  
	  }
	  
	  List<Building> result = new ArrayList<>();
	  for(Building building : buildings) {
			 switch ( building.getClass().getSimpleName()) {
			    case "CityHall":
			    	Building newBuildCityHall = new CityHall();
			    	result.add(newBuildCityHall);
			      break;
			      
			    case "FireDepartment":
			    	Building newBuildFireDepartment = new FireDepartment();
			    	result.add(newBuildFireDepartment);
				      break;
				      
			    case "House":
			    	Building newBuildHouse = new House();
			    	result.add(newBuildHouse);
				      break;
				      
			    case "Market":
			    	Building newBuildMarket = new Market();
			    	result.add(newBuildMarket);
				      break;
			    case "PowerPlant":
			    	Building newBuildPowerPlant = new PowerPlant();
			    	result.add(newBuildPowerPlant);
				      break;
				      
			    case "School":
			    	Building newBuildSchool = new School();
			    	result.add(newBuildSchool);
				      break;
				      
			    case "WaterTower":
			    	Building newBuildWaterTower = new WaterTower();
			    	result.add(newBuildWaterTower);
				      break;

			    default:
			      break;				      

			   }
		  }
		  return result; 
  }

  public static List<Building> randomTown() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	  List<Building> buildings = new ArrayList<>();
	  
	  for (Class<?> klazz :  ClassUtils.getClasses("fr.mds.java.design_pattern.tp3")) {
			  if(klazz.getInterfaces().length > 0 && klazz.getInterfaces()[0].getName().equals(Building.class.getName())) {
				  buildings.add((Building) klazz.getConstructor().newInstance());
			  }		  
	  }
	  
	  List<Building> result = new ArrayList<>();
	  System.out.println("randoms: ");
	  for (int i = 0; i < 20; i++) {
		  Random randInt= new Random();
		  int numb = randInt.nextInt(buildings.size());
		  switch ( buildings.get(numb).getClass().getSimpleName()) {
		    case "CityHall":
		    	Building newBuildCityHall = new CityHall();
		    	result.add(newBuildCityHall);
		      break;
		      
		    case "FireDepartment":
		    	Building newBuildFireDepartment = new FireDepartment();
		    	result.add(newBuildFireDepartment);
			      break;
			      
		    case "House":
		    	Building newBuildHouse = new House();
		    	result.add(newBuildHouse);
			      break;
			      
		    case "Market":
		    	Building newBuildMarket = new Market();
		    	result.add(newBuildMarket);
			      break;
		    case "PowerPlant":
		    	Building newBuildPowerPlant = new PowerPlant();
		    	result.add(newBuildPowerPlant);
			      break;
			      
		    case "School":
		    	Building newBuildSchool = new School();
		    	result.add(newBuildSchool);
			      break;
			      
		    case "WaterTower":
		    	Building newBuildWaterTower = new WaterTower();
		    	result.add(newBuildWaterTower);
			      break;

		    default:
		      break;				      

		   }
	  }
	return result;  
  }
}