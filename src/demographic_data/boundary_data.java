package demographic_data;

import java.io.FileReader;
import java.io.IOException;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import au.com.bytecode.opencsv.CSVReader;

public class boundary_data {
    
    public static void main(String[] args) throws IOException, ParseException {
        String outputFilePath = "/home/shatam-system-i2/akash_created_demographic_project/resi_data/demographic_layer.csv";
        
        // Define your second multipolygon here
        String secondMultiPolygonWKT = "MULTIPOLYGON (((-117.7373446635632 34.01881785376064, -117.73664194026253 34.01870571963919, -117.73586642647436 34.01857969906212, -117.73014168056096 34.021356748573744, -117.72842291506323 34.03153524519038, -117.72737594836254 34.03740245064328, -117.72456102711409 34.04522468333473, -117.72069241078347 34.05597376214552, -117.71828266655912 34.062660639708156, -117.71642014276813 34.06746592408484, -117.71344175059583 34.074247383409485, -117.7070176437759 34.08889775213262, -117.70682701767937 34.08960460637225, -117.70633530863891 34.09072424018496, -117.70342702817793 34.090665654828335, -117.70342716292524 34.092538730239674, -117.70551586633503 34.09259377693977, -117.70500034295642 34.09379391852301, -117.70029157096813 34.093791139261015, -117.69898206443911 34.09555675195853, -117.69829026375398 34.09571766965597, -117.69623230877802 34.09593985276934, -117.69173508105595 34.0959526395785, -117.68963423422014 34.09594243259696, -117.68961949196799 34.093907427046545, -117.6809445178631 34.093887441082785, -117.68090521656944 34.08726614088073, -117.68087818895745 34.08365525785581, -117.68086353384194 34.0814765029095, -117.68083860199957 34.077694215158644, -117.68084179012047 34.073678960416586, -117.680843706227 34.07056863760671, -117.68084719079197 34.06547753534713, -117.68084858587561 34.0633838311527, -117.68084866043579 34.063275706055414, -117.68084535463554 34.0628070658768, -117.68082347796341 34.05986404407301, -117.6808730002884 34.059863777645155, -117.68085889763675 34.058494794807785, -117.68075201788088 34.04843165494611, -117.68082287699049 34.04842693451775, -117.68087844228238 34.047841647001235, -117.68082694456209 34.04092488090076, -117.68082531142491 34.04077027491094, -117.70478340610352 34.0406220479829, -117.7047786746769 34.038923429197915, -117.70369136104352 34.03893152971145, -117.703669571508 34.03711784248931, -117.70475784544043 34.03710954155583, -117.70472312735133 34.03348707392232, -117.70689584300317 34.0334745151612, -117.70687504161442 34.032210821075296, -117.70741369571329 34.03220258591807, -117.70815862905255 34.0321948473114, -117.70908692291432 34.03218754718789, -117.70909173339268 34.03080408353111, -117.70974205167462 34.03069993179713, -117.71084823442054 34.03056665705633, -117.71122520524298 34.030536304304135, -117.71244465835973 34.03037180174254, -117.71340647914454 34.030218534435356, -117.71553610890041 34.029655412394334, -117.71553032554658 34.02798568587488, -117.71338909045558 34.027990517625675, -117.71336698381477 34.02618249224821, -117.71554560499126 34.02616763038829, -117.71550971010912 34.02209870635992, -117.71770132182297 34.02339050301507, -117.71759165459476 34.011719110352274, -117.71758725195154 34.01151963523128, -117.7238796388014 34.01148355388086, -117.72630505413592 34.01146815107498, -117.72939650737153 34.01144765569573, -117.72938108419643 34.01144446045942, -117.72964450617035 34.01147367404418, -117.72858197885228 34.00701555075074, -117.73295071514936 34.01144973844471, -117.73305649446901 34.01153684451469, -117.74118495062302 34.01698304670498, -117.74156222597436 34.017257287773376, -117.74182897890135 34.01747918447252, -117.74216017517018 34.0177940780748, -117.74241963467539 34.018079480734976, -117.742856952522 34.01861657855823, -117.7438542890999 34.01982329339871, -117.74313384293698 34.01973873404935, -117.7408770009571 34.01937810295457, -117.74011494572855 34.01925642197505, -117.73863641938219 34.01902082163868, -117.73816911756803 34.01895055948683, -117.7373446635632 34.01881785376064)))";
        GeometryFactory geometryFactory = new GeometryFactory();
        WKTReader wktReader = new WKTReader(geometryFactory);
        MultiPolygon secondMultiPolygon = (MultiPolygon) wktReader.read(secondMultiPolygonWKT);
        
        try (CSVReader reader1 = new CSVReader(new FileReader(outputFilePath))) {
            reader1.readNext(); // Skip header row if present
            
            String[] cell;
            while ((cell = reader1.readNext()) != null) {
                if (cell.length > 0) {
                    String firstColumnValue = cell[2]; // Access first column value
                    MultiPolygon firstMultiPolygon = (MultiPolygon) wktReader.read(firstColumnValue);
                    
                    boolean isContained = firstMultiPolygon.contains(secondMultiPolygon);

                    if (isContained) {
                        System.out.println("One MultiPolygon from the first column contains one MultiPolygon from the second column.");
                    } else {
                      //  System.out.println("No containment between MultiPolygons from the first and second columns.");
                    }
                }
            }
        }
    }
}
