package demographic_data;



import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class land_area {
    public static void main(String[] args) {
        // MULTIPOLYGON string in WKT format
        String wktString = "MULTIPOLYGON(((-121.69184000001593 36.65885199962014,-121.68509700022634 36.66680600039666,-121.68484500029649 36.66670500023565,-121.68387399958539 36.66631700032934,-121.68112999984959 36.665284000356394,-121.67976599990095 36.66475900042758,-121.67812099958445 36.66413799966898,-121.67335600017924 36.66232599974512,-121.6733039995799 36.66230599972215,-121.67322200029503 36.662275000091256,-121.67236600039058 36.66212699956145,-121.67201600043802 36.66212100018407,-121.67144400014047 36.66203299972324,-121.67084300030416 36.66194099997722,-121.66872899994337 36.66121499977248,-121.66852699962129 36.661146000187784,-121.66732800008708 36.66068999984367,-121.66703500006514 36.66057900012083,-121.6665629998825 36.66039899991398,-121.66641200011367 36.66032099991429,-121.66626399958386 36.6602369996379,-121.66612400032233 36.66014599993798,-121.66598800034592 36.66005000000757,-121.66585999983909 36.65994699975431,-121.6657389996551 36.659840000215866,-121.66562399974777 36.65972800044693,-121.6655330000479 36.65963099957105,-121.66504299993449 36.658844000150566,-121.6649370004422 36.65865699962086,-121.66474799982029 36.658301000290976,-121.66457099975179 36.65797999987717,-121.66433599970657 36.657692000085774,-121.66405700033027 36.65741199976401,-121.66372899959362 36.65715899978807,-121.66341799964096 36.656978000434435,-121.66295199973496 36.656762000366086,-121.6622170000145 36.65647999995207,-121.66021500032195 36.655718999931935,-121.6604710004363 36.65507499991139,-121.66076200036599 36.65423099966097,-121.66085900034255 36.653913000284774,-121.66106099976531 36.65325000028736,-121.66201000036119 36.65054799979043,-121.66228999978364 36.64974999986265,-121.66253800042836 36.64904299963479,-121.6629909997348 36.647793000446654,-121.66309099984971 36.647534000194014,-121.66394399961587 36.64531000015643,-121.66420299986851 36.64465399958249,-121.66662099985922 36.64586100038491,-121.6676030001783 36.646366000290755,-121.67653400014393 36.650890000273364,-121.67860899960561 36.651925000338565,-121.68012999959979 36.6527149998974,-121.68532499994876 36.65535000000256,-121.68594899994633 36.655672999609294,-121.68614299989952 36.655773999770304,-121.6866600003587 36.65604200043805,-121.6866829996207 36.65605400009207,-121.68676499980484 36.656096000230264,-121.69159699960181 36.65860099973639,-121.69191399983117 36.65876500010472,-121.69184000001593 36.65885199962014)))";

        // Create a WKTReader
        WKTReader reader = new WKTReader();

        try {
            // Parse the WKT string to a Geometry object
            Geometry geom = reader.read(wktString);

            // Get area in square degrees
            double areaInSquareDegrees = geom.getArea();

            // Conversion factor from square degrees to square kilometers (approximation for Earth's surface)
            double squareDegreesToSquareKm = 111.32 * 111.32; // Approximately 111.32 km in each degree (at equator)

            // Calculate area in square kilometers
            double areaInSquareKm = areaInSquareDegrees * squareDegreesToSquareKm;

            // Conversion factor from square kilometers to square miles
            double squareKmToSquareMiles = 0.386102; // Approximately 0.386102 square miles in each square kilometer

            // Calculate area in square miles
            double areaInSquareMiles = areaInSquareKm * squareKmToSquareMiles;

            // Print the results
            System.out.println("Area in square kilometers: " + areaInSquareKm);
            System.out.println("Area in square miles: " + areaInSquareMiles);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
