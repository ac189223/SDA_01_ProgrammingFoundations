package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {

    /** =================    =================    Date format validation    =================   ================= */

    public boolean isThisDateValid(String dateToValidate, String dateFromat){

        if (dateToValidate == null) { return false; }                   // Empty date is not valid

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);        // Setting valid format according to input
        sdf.setLenient(false);                                          // To avoid transformation of input like 20191575

        try {
            Date date = sdf.parse(dateToValidate);                      // Try to fit date into selected format
        } catch (ParseException e) {
            return false;                                               // Return false if does not fit
        }
        return true;                                                    // Return true if it is ok
    }
}