package org.example.tpproduct.models.selling;

public enum SellingStatus {
    OUTSTANDING,
    FINISHED,
    CANCELED;

    public static SellingStatus getSellingStatus(String string){
        SellingStatus sellingStatus = null;
        switch (string){
            case "OUTSTANDING" -> sellingStatus = OUTSTANDING;
            case "FINISHED" -> sellingStatus = FINISHED;
            case "CANCELED" -> sellingStatus = CANCELED;
        }
        return sellingStatus;
    }
}
