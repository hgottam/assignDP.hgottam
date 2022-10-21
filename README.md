# assignDP.hgottam


## Implemented Facade, Bridge, Factory, Iterator, Visitor design patterns.

* Facade design pattern: Implemented this design pattern by delegating functionalities to various classes like Login, Trading and interfaces like ProductMenu. Implemented appropriate methods as required.
Implemented in classes: PTBS.java, remiderVisitor.java, Login.java, ProductMenu.java

* Bridge design pattern: Implemented this design pattern to display the PTBS menu options. Based on user type, Buyer and Seller menu options are displayed. Similarly based on the type of product, i.e, Meat and Produce , respective menu is shown based on user selection.
Implemented in classes: PTBS.java (Creation of respective type)

* Factory design pattern: Implemented this design pattern to instantiate classes as per need. "Person" abstract class is accessed and instantiated as buyer and seller at runtime using information present in seller.txt and buyer.txt
Implemented in classes: PTBS.java, MeatProductMenu.java, ProduceProductMenu.java, Buyer.java, Seller.java


* Iterator design pattern: This design pattern is implemented with help of productIterator method where the all the products are easily accessed by other parts of the system.
Implemented in classes: ClassProductList.java, ProductIterator.java, ListIterator,java, UseInfoItem.java


* Visitor design pattern: Implemented this design pattern to call remind and to accept the trading between buyer and seller. For simplicity of the code, called remindVisitors methods from facade and trading classes.
Implemented in classes: ReminderVisitor.java, Facade.java, Tading,java


# Execution flow-
User logs into the system --> user to select type of product(Meat/ Produce) --> Application displays options for user to select (show menu, add, view, remind) --> Output shown based on user selection --> By reading seller and buyer text files, user type(buyer/seller) is determined and respective menu is displayed --> user selects an option --> Output shown based on user selection (show repective menu/ create new menu)--> end of application

UserInfoItem userinfo contains enitre data stored as HashMap<userName, List<person>>. The Person is stored as an object with usertype, personanme and products (productlist) associated with the person. All the data are linked and stored in the above hashmap.

#Provided high level functionality comments for all implementated methods in the source code
