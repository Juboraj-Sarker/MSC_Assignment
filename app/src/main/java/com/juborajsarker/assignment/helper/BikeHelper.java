package com.juborajsarker.assignment.helper;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import com.juborajsarker.assignment.R;
import com.juborajsarker.assignment.model.Bike;

import java.util.ArrayList;
import java.util.List;

public class BikeHelper {

    private Context context;

    public BikeHelper(Context context) {
        this.context = context;
    }

    public List<Bike> getBikeListWithBrand(String brandName){

        List<Bike> bikeList = new ArrayList<>();

        if (brandName.equals("Bajaj")){

            Bike bike1 = new Bike("Bajaj Avenger 150 Street", "Bajaj", "India", "1,99,500", R.drawable.bajaj_avenger);
            Bike bike2 = new Bike("BAJAJ PULSAR NS160", "Bajaj", "India", "1,89,500", R.drawable.bajaj_ns_160);
            Bike bike3 = new Bike("BAJAJ PULSAR 150", "Bajaj", "India", "1,67,900", R.drawable.bajaj_pulsar);
            Bike bike4 = new Bike("BAJAJ DISCOVER 125", "Bajaj", "India", "1,28,900", R.drawable.bajaj_discover);

            bikeList.add(bike1);
            bikeList.add(bike2);
            bikeList.add(bike3);
            bikeList.add(bike4);

        }else if (brandName.equals("Honda")){

            Bike bike1 = new Bike("HONDA CBR 150R", "Honda", "Japan", "4,50,000", R.drawable.honda_cbr);
            Bike bike2 = new Bike("HONDA X BLADE", "Honda", "Japan", "1,72,900", R.drawable.honda_xblade);
            Bike bike3 = new Bike("HONDA CB HORNET", "Honda", "Japan", "1,86,800", R.drawable.honda_hornet);
            Bike bike4 = new Bike("HONDA CB TRIGGER", "Honda", "Japan", "1,91,000", R.drawable.honda_cb_trigger);

            bikeList.add(bike1);
            bikeList.add(bike2);
            bikeList.add(bike3);
            bikeList.add(bike4);

        }else if (brandName.equals("Suzuki")){

            Bike bike1 = new Bike("SUZUKI GIXXER SF CARBURETOR", "Suzuki", "Japan", "2,59,950", R.drawable.suzuki_gixxer_sf_150);
            Bike bike2 = new Bike("SUZUKI GIXXER 155", "Suzuki", "Japan", "2,19,950", R.drawable.suzuki_gixxer_155);
            Bike bike3 = new Bike("SUZUKI GIXXER", "Suzuki", "Japan", "1,74,950", R.drawable.suzuki_gixxer150);
            Bike bike4 = new Bike("SUZUKI HAYATE EP", "Suzuki", "Japan", "99,950", R.drawable.suzuki_hayate);

            bikeList.add(bike1);
            bikeList.add(bike2);
            bikeList.add(bike3);
            bikeList.add(bike4);

        }else{

            Bike bike1 = new Bike("YAMAHA R15 V3", "Yamaha", "Japan", "4,85,000", R.drawable.yamaha_r15);
            Bike bike2 = new Bike("YAMAHA MT-15", "Yamaha", "Japan", "4,10,000", R.drawable.yamaha_mt_15);
            Bike bike3 = new Bike("YAMAHA FAZER FI", "Yamaha", "Japan", "2,71,000", R.drawable.yamaha_fazer);
            Bike bike4 = new Bike("YAMAHA FZS FI V2", "Yamaha", "Japan", "2,10,000", R.drawable.yamaha_fzs_v2);

            bikeList.add(bike1);
            bikeList.add(bike2);
            bikeList.add(bike3);
            bikeList.add(bike4);
        }

        return  bikeList;
    }

    public int dpToPx(int dp) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
