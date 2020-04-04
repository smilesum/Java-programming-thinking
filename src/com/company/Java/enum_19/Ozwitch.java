package com.company.Java.enum_19;

public enum Ozwitch {
   WEST("west"),
   NORTH("north");

   private String describtion;
   private Ozwitch(String describtion) {
     this.describtion = describtion;
   }
   public String getDescribtion() {
     return describtion;
   }
   public static void main(String[] args) {
     for(Ozwitch ozwitch: Ozwitch.values()) {
       System.out.println(ozwitch.getDescribtion());
     }
   }
}
