package com.company.Java.enum_19;

enum SecurityCategory {
  STOCK(security.Stock.class),BOND(security.Bond.class);
  security[] values;
  SecurityCategory(Class<? extends security> cls) {
    values = cls.getEnumConstants();
  }
  interface security {
    enum Stock implements security{SHORT,LONG};
    enum Bond  implements security{MUNI,JUNK};
  }

  public security randomSelection() {
    return Enums.random(values);
  }

  public static void main(String[] args) {
    for(int i=0;i<5;i++) {
      SecurityCategory securityCategory = Enums.random(SecurityCategory.class);
      System.out.println(securityCategory.randomSelection());
    }
  }
}
