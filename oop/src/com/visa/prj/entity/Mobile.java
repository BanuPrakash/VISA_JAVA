package com.visa.prj.entity;

// Specialization
public class Mobile extends  Product{
    private  String connectivity;

    public Mobile() {
//        super();
    }

    public Mobile(int id, String name, double price, String connectivity) {
        super(id, name, price);
        this.connectivity = connectivity;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    @Override
    public boolean isExpensive() {
       if("3G".equals(connectivity) && getPrice() > 4000) {
           return  true;
       } else if("4G".equals(connectivity) && getPrice() > 8000) {
           return  true;
       } else  if("5G".equals(connectivity) && getPrice() > 40000) {
           return  true;
       }
       return  false;
    }

    @Override
    public String toString() {
        return super.toString() + "Mobile{" +
                "connectivity='" + connectivity + '\'' +
                '}';
    }
}
