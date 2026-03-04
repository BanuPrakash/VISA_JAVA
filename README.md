# Java 
```
Banu Prakash C
Full Stack Architect, Corporate Trainer
Co-founder & CTO: Lucida Technologies Pvt Ltd.,
Email: banuprakashc@yahoo.co.in
banuprakash.cr@gmail.com
https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/VISA_JAVA

```

Softwares Required:

```
1) openJDK 21 https://jdk.java.net/java-se-ri/21
Option 1: install and add path and JAVA_HOME
vi ~/.zshrc export JAVA_HOME=/Users/banuprakash/Desktop/jdk-21
export PATH="/Users/banuprakash/Desktop/jdk-21/bin:"$PATH

Option 2: [better]
USE SDKMAN to manage java
curl -s "https://get.sdkman.io" | bash
sdk install java 21.0.6-tem
sdk default java 21.0.6-tem

https://mydeveloperplanet.com/2022/04/05/how-to-manage-your-jdks-with-sdkman/#:~:text=Some%20time%20ago%2C%20a%20colleague%20of%20mine,maintain%20different%20versions%20of%20JDKs%2C%20Maven%2C%20etc.

$ java --version

2) IntelliJ Ultimate or Community edition https://www.jetbrains.com/idea/download/?section=mac

3) MySQL [ Prefer on Docker]
Install Docker Desktop
Docker steps:
a) docker pull mysql
b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql
container name given here is "local-mysql"
For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

c) CONNECT TO A MYSQL RUNNING CONTAINER:
$ docker exec -t -i local-mysql bash

d) Run MySQL client:
bash terminal> mysql -u "root" -p
mysql> exit

```
OOP: Object Oriented Paradigm
* Real world
Object - state and behaviour/actions

Template - class , function , type

SOLID design principles:
SRP --> Single Reposibility

OCP -> Open for extension and Closed for Change.

L -> Liskov Substitution Principle

I -> Interface seggregation

D -> Dependency Injection (Inversion Of Control)

=======================

What is Java?
Technology
Platform - for executing bytecode [portable]

Java Language -- javac - bytecode
Kotlin -- Kotlin Compiler -- bytecode
Groovy --> Groovy Compiler -- bytecode

Account.java
javac Account.java ===> Account.class
```
    public class Account {
        private double balance; // state, instance variables

        // instance methods, actions, behaviours
        public void deposit(double amt) {
            balance += amt;
        }

        public void withdraw(double amt) {
            this.balance -= amt;
        }

        public double getBalance() {
            return this.balance;
        }
    }

```

AccountExample.java
javac AccountExample -> AccountExample.class
```
    public class AccountExample {
        public static void main(String[] args) {
            Account swethaAcc = new Account(); // instances, Objects
            Account riaAcc = new Account();
            
            swethaAcc.deposit(5000);

            System.out.println(swethaAcc.getBalance());
        }
    }

```

Java RuntimeEnvironment [ target ]

java AccountExample 

ClassLoader: 
    Loads the .class file from Secondary to Primary Storage
    folder where you are executing, CLASSPATH env variable
    1) findLoadedClass()
    2) loadClass()
    3) defineClass()

    2a) findSystemClass() --> defineClass()
    

METASPACE

===========================

* instance variables / state ==> HEAP area
* instance methods ==> any methods executed on Stack
* local variables ==> stack

Any variables if memory is allocated on METASPACE / HEAP area will have default values
Variables on Stack won't have default values, you need to initialize before using.

==============================

Libraries --> jar [ Java Archive ], war --> Web Archive, EAR --> Enterprise archive

Logically grouping of classes / objects
1) Entity / Model / Domain classes
    -> Generally assocaited with a persistent store [ like database , files]
    -> state
    -> getters and setters
    -> constructor
    -> equals() and hashCode()
2) DAO Data Access Objects
    CODE to interact with persistent layer
3) Business Layer
4) Utility: Helpers
5) Exception classes
6) Service: facade over DAO and Business layer
```
BankingService
    void transferFunds(Account fromAcc, Account toAcc, double amt){
        // SELECT balance ->DAO
        // update fromAcc -> DAO 
        // update toACC --> DAO
        // INSERT to Tx table --> DAO
        // send SMS
        // Send EMAIL
    }

```
7) UI / Client


packages --> folders for logically grouping

```
package com.visa.project.entity
public class Employee {
    
}

    com
     |
     visa
        |
        project / module
            |
            entity
                ... classes
            dao
                ...classes
            service
                ...classes
    ...
```

Relationship between objects.
1) Generalization and Specialziation
2) Realization
3) Association [ Composition or Aggregation]
4) Uses A

Bad Code:
```
    class Tv {
        id,
        name,
        price,
        screenSize,
        screenType
        getters / setters
    }

    class Mobile {
         id,
        name,
        price,
        camera,
        connectivity,
        memory
    }

```

Modify:
```
How Constructors are chained
class Product {
    Product() {
        "P1"
    }

    Product(id, name) {
        "P2"
    }
}

    class Mobile {
        Mobile(){
            "M1"
        }

        Mobile(id, name, price, connect) {
            super(id, name);
            "M2"
        }
    }

    new Mobile(); // P1, M1
    new Mobile(24, "iPhone", 89000.00, "5G"); // P1, M2 to // P2, M2
```

How Methods work?

```
    class Product {
        getPrice() {
            return 100;
        }
    }

    class Mobile extends Product {
        getPrice() {
            return 500;
        }

        getConnectivity() {
            return "5G"
        }
    }

    Mobile m = new Mobile();
    m.getPrice(); // 500
    m.getConnectivity(); // 5G

    Product p = new Mobile();
    p.getPrice(); // 500
    p.getConnectivity(); // ERROR

```

Day 2:

Visibility: 
1) private --> within class
2) default -> within class, other classes within same package
3) protected -> within class, other classes within same package, other inherited classes even if present outside package
4) public 

Override, reflection API.

================================
Realization relationship:

Represents a contract fulfillment where a class provides the implementation for methods declared in an interface.

"implements" connection between two model elements, where a classifier (like a class) fulfills the contract or behaviors defined by another (like an interface or component).

Java provides interface for realization relationship.

interface InterfaceName {
    abstract methods()
    can have constants
    can't have state
}

Why program to interface?
1) DESIGN
2) IMPLMENTATION
3) INTEGRATION
4) TESTING
5) LOOSE COUPLING
6) OCP

```
    interface Swim {
        swim();
    }

    interface Dance {
        dance()
    }

    interface Fight {
        fight();
    }

    public class Actor implements Dance {
        public void dance() {

        }
    }

    public class Hero extends Actor implements Fight, Swim {
        fight() {}
        swim() {}
    }

    Fight f = new Hero();
    f.fight();
    f.dance(); // error

    Swim s = (Swim) f;
    s.swim(); // works

    Dance d = (Dance) s;
    d.dance();

---

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    // state
    // behaviour
    public void fly() {

    }
}

class AeroPlane implements Flyable {
    // state
    // behaiour
     public void fly() {

    }
}

class FlyAttempt implements Flyable {
     public void fly() {
        jump from 4th Floor
    }
}

Flyable f = new Flyable() {
     public void fly() {
        jump from 4th Floor
    }
}

f.fight();

// Unit of Work - Thread
interface Runnable {
    void run();
}

public class WorkerThread implements Runnable {
    //
    public void run() {
        //
    }
}

new Thread(new WorkerThread()).start();

new Thread(new Runnable(){
    public void run() {
        while(true) {
            Thread.sleep(1000);
            sout(Date.now());
        }
    }
})
```
An anonymous class is a class without a name that is declared and instantiated in one step. 
It’s typically used when you need a short-lived implementation of an interface or abstract class.

When NOT to Use Anonymous Classes
 * When logic is large
 * When reused in multiple places
 * When readability suffers

===============

Generics:
* Generic class
* generic method
* generic interfaces

```
    class Rectangle {
        int width;
        int breadth;
    }

    class DRectangle {
        double width;
        double breadth;
    }

    Solution:
    class Rectangle<T> { ===> class Rectnagle {
        T width;                    Object width;
        T breadth;                  Object breadth;
    }                           }

    Rectangle<Integer> r1 = new Rectangle<Integer>(5,6);
    Rectangle<Double> r2 = new Rectangle<Double>(4.5, 1.2);
    Rectangle<String> r3  = new Rectangle<String>("A", "B");

     class Rectangle<T extends Number> { ===> class Rectnagle {
        T width;                                 Number width;
        T breadth;                              Number breadth;
    }                                    }

    class  LinkedList<T extends Product> {
        T node;
    }

    class Pair<K,V> {
        K key;
        V value;
    }

    Pair<String, Double> pairs = new Pair<>("Java", 8902.33);

    Generics can't be used for primitive type [int, double, short, ...]

    Integer is a typewrapper for int
    Double is a typewrapper for double

    int x = 100; 
    Integer iX = x; // boxing

    int y = iX; // unboxing
```
Java: Class, interface, Annotation, Enum

Annotations: Metadata
1) Who uses it?
    a) COMPILER
    b) CLASSLOADER
    c) RUNTIME
2) Where can I use it?
a) METHOD --> @Override
b) TYPE -> class, interface , annotation
c) fields
d) parameters


``` 
    Assume Device is a annotation:
    Target --> Type
    Retention -> CLASS

    @Device(name="samsung")
    public class CandyCrush extends Game {

    }


    @Table(name="books")
    public class Book {

        @Column(name="book_id", type="NUMERIC(10)")
        int id;

        @Column(name="BOOK_TITLE")
        String title;

        @Column(name="AMT", type="NUMERIC(12,2)")
        double price;
    }


    DDL and DML
    create table books (book_id NUMERIC(10), BOOK_TITLE varchar(255), AMT NUMERIC(12,2));

    insert into books values (...);

```

String is immutable
StringBuffer and StringBuilder are muttable.

String str = "Hello";

str += " World";
str += " 123";
str += " ...";


System.out.println(str); // Hello World 123 ...

=============================

Exception and Exception Handling

Any abnormal condition that arises during program executions is an exception
Exception is an object:
1) What went Wrong?
2) Why?
3) Where?

Exception --> Exception Type or Error Type
Exception -> can be handled and provide alternate flow / solution
Error -> Program terminates, mo solution at runtime
Examples of Error: StackOverflowError, OutOfMemoryError,..


Exception Type:
Checked or Unchecked Exception

Unchecked Exception:
NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, ClassCastException

CheckedException:
ClassNotFoundException, SQLException, IOException , SocketException 

```
try {
    Connection con = DriverManager.getConnection(URL, USER, PWD);
    ...
} catch(SQLException ex) {
    ex.printStackTrace()l
}

try {
    ..
} catch(FileNotFoundException ex) {

} catch(IOException ex) {

} catch(Exception ex) {
    
}
```
=========

Java Collection Framework
* interfaces
* implementation classes
* Utility / Algorithm classes

```
List                                        Set
* Ordered                                   not-ordered
* index based operations                    not-support
* duplicates                                unique
* supports re-ordering                      not-supported
Vector, Stack, ArrayList,LinkedList         HashSet, TreeSet

Vector and Stack are legacy: not supposed to be used [ methods are synchronized]
```

Different ways of using List.
1) ArrayList list = new ArrayList(); // BAD

2) List list = new ArrayList(); // Better , but not good
    Not TypeSafe:
    list.add("A");
    list.add(34);
    list.add(new Date());

    list.get(0); // Need type checking

3) List<Product> list = new ArrayList<>(); // GOOD

Note: arrays are covariant
Generic collections are not covariant

===============

HOF: High Order Functions
1) functions accepting function as argument
2) function returns a function

Treat function as first-class member

Streams: sequence of data flow
Commonly used HOF are:
1) filter : subset based on Predicate fn
2) map : transform
Example: List<Product> ==> List<Double>
List<Product> ==> UI Card
3) reduce
Aggregate: sum(), count(), avg() 
4) forEach
5) flatMap
https://rxmarbles.com/


```

    filter(List src,Predictate predicateFn) {
        List dest = new ...
        for(Object elem: src) {
            if(predicateFn(elem)) {
                dest.add(elem)
            }
        }
        return dest;
    }

```
Which one to use?
```
Use ArrayList when:
You read more than write
You need fast indexing
90% real-world cases

Use LinkedList when:
You frequently insert/remove at head
Implementing Queue/Deque behavior
```

Funtional interfaces:
1) Function
2) BiFunction
3) BinaryOperator
4) Predicate
5) Consumer

Data flows in a stream only when we have a terminal function connected:
1) reduce
2) forEach
3) collect

================

Set -> unique
HashSet [90%]
TreeSet [2 %] --> sorted -> RedBlack Tree
LinkedHashSet [8 %] -> maintains order

HashSet uses hashCode() and equals() -> duplicate identification and ordering

HashCode: Numerical representaion of object based on state
1) Similar objects should have same hashcode
2) dissimilar objects can also have same hashcode

Bad HashCode
```
    public class Rectangle {
        width, breadth;

        public int hashCode() {
            return width * breadth;
        }
    }

    Rectangle(4,5) -> 20
    Rectangle(5,4) -> 20
    Rectangle(20,1) -> 20
    ..
```

Map --> Key / Value 
Registry, Dictionary , Form data, 
HashMap, TreeMap [keys are sorted], LinkedHashMap [ordering of Key is maintained]
Hashtable (legacy)


=================

```
    Key / Value Pair --> YES

        Map
        Retreive based on Key --> HashMap / Hashtable (legacy)
            Object used for Key has to have hashCode() and equals()
            Key has to be unique [ only one key can be null]
            Value can be duplicate, can have null values
        Store based on sorted Keys -> TreeMap [ RedBlack Tree]
            Avoid this for frequent add /remove operations
            Null key not supported
        Store keys based on insertion order: LinkedHashMap
        ConcurrentHashMap --> thread safe Map container
    
    Not Key / value pair
        Unique values - Set
            HashSet, for faster access [ good for arbitrary add / remove operations]
            TreeSet - sorted by values
        Set<String> set = new TreeSet<>(); // this uses comparable interface

        Set <String> set = new TreeSet<>((s1, s2) -> {
            int diff = s1.length() - s2.length();
            if(diff == 0 ) {
                diff = s1.compareTo(s2);
            }
            return diff;
        }); // comparator

     Not Unique:
        List:
            ArrayList: not efficient for add / remove from arbitrary position
            efficient for index based operation
            LinkedList: where hugh data needs to be stored
             efficient for add / remove from arbitrary position
            
    Stack or Queue: FILO or LIFO --> LinkedList
    Queue: PriorityQueue:   
    ArrayBlockingQueue    

```

Garbage Collection:

C / C++ : we allocate and release memory [free or delete]

MSC, G1GC, Epsilon GC , ZGC

java  -XX:+UseEpsilonGC -jar YourApplication.jar

System.gc(); // request and not a demand

================

Java Concurrent Programming

Why Concurrent Programming?
* Avoid starvation
* Resource re-usability
* Application can continue even if one unit of work fails.

JVM waits for the last non-daemon thread to finish its execution, doesn't wait for Daemon threads to finish job.

Main Thread is a non-daemon thread

Daemon Thread
D1, D2 , D3
Non-Daemon Threads
N1, N2 , N3

=======================

Java Threads --> Posix threads [ OS Threads]
```

interface Runnable {
    void run();
}

class Thread {

}

thread class contains life-cycle methods to handle threads
a) start()
b) yield()
c) sleep()
d) join()
e) interrupt()

deprecated methods:
f) stop()
g) suspend()
i) resume()


Thread t = new Thread();
t.start(); 

class GrammerCheck implements Runnable {
    ..
    public void run() {
        ...
    }
}


Thread t = new Thread(new GrammerCheck());
t.start();

class SpellCheck extends Thread {
     ..
    public void run() {
        ...
    }
}

SpellCheck t = new SpellCheck();
t.start();

```

Thread Safety:
- data doesn't get corrupted in multithreaded environment

local variables -- thread safe
class variables -- static -- metaspace -- shared by all Threads -- not thread safe
instance var -- heap -- shared by threads -- not thread safe
immutable objects -- heap -- shared by threads -- thread safe
volatile members -- heap -- shared -- thread safe [ only atomic members should be marked volatile] - boolean
float f = 1.6f;
f += 10.3;

int x = 10;
x++;

volatile boolean flag = true;

volatile --> marker to safe no optimization

==========================================================

Inter-thread communication : wait(), wait(ms), notify() and notifyAll() --> Object methods

```
class Util {
    public copyElements(List<Product> dest, List<Product> src) {
        syncronized(dest) {
            syncronized(src) {
                ... 
            }
        }
    }
}
class BankingService {
    public  void transferFunds(Account fromAcc, Account toAcc, double amt) {
       synchronized(fromAcc) {
        synchronized(toAcc) {
            ...
        }
       }
    }
}

T1: SA105 to SA890 5000
T2: SA890 to SA911 3500

```

Issues with Java Concurrency:
1) One lock per object
Solution: Lock api instead of synchronized
2) Runnable : doesn't return a value, nor throws a Exception
void run();
Solution : Callable and Future
interface Callable<T> {
    T call() throws Exception;
}

3) Issues with syncronized and deadlocks

4) No timeout for acquiring lock

```

class BankingService {
    public  void transferFunds(Account fromAcc, Account toAcc, double amt) {
      if(fromAcc.balanceLock.tryLock(2000)) { // T1 105 // T2 890
        try {
            if(toAcc.balanceLock.tryLock(2000)) { // T1 890 T2 105
              try {
                    // do transaction
                } finally {
                    toAcc.balanceLock.unlock();
                }
        }
        } finally {
            fromAcc.balanceLock.unlock();
        }
       }
    }
}
T1: SA105 to SA890 5000
T2: SA890 to SA105 3500
```

a() -> b() -> c();

=====================

docker pull mysql:latest
docker run --name my-mysql  -e MYSQL_ROOT_PASSWORD=Welcome123 –p 3306:3306 -d mysql:latest

Maven:
Java Build tool
* Manage dependencies
* execute goals

Dependency Libaries are available in the form of jar files.

Java Archive

1) We can add jars to project by downloading them from different repositoriries

pom -> Project Object Model


===============

JDBC: Java Database Connectivity
integration library used to connect to RDBMS

JDBC provides interfaces; implementation classes are provided by database vendors

Steps :
1) Load database vendor provided classes into JRE
Class.forName("driver class");

Class.forName("com.mysql.jdbc.Driver");

Class.forName("oracle.jdbc.Driver");



2) Establish a database connection: should be short lived

Connection con = DriverManager.getConnection(URL, USER, PWD);

3) Send SQL :DDL or DML
a) Statement: for SQL which is fixed, same SQL for n Requests

select * from products

b) PreparedStatement: for SQL which takes IN parameters

select * from users where username = ? and password = ?

insert into products values (?, ?, ? , ?);

AVOID SQL Concatination:

"select * from users where username = '" + uname + "'  and password = '" + pwd + "'";


c) CallableStatement: to invoke functions / Stored procedures of database

```
CREATE PROCEDURE GetCustomersByCity
  @City nvarchar(50)
AS
BEGIN
  SELECT * FROM Customers
  WHERE City = @City;
END;

```

call GetCustomersByCity('BLORE')

===============

Methods:
1) int executeUpdate() == INSERT, DELETE and UPDATE SQL
2) ResultSet executeQuery() == SELECT 
ResultSet is a cursor to the selected view
ResultSetMetaData --> for column count, column names, datatype of columns , ...

note: Always use finally block to release resources

=============

Once MySQL container is running on Docker.

```
    Need to access container from terminal
    docker exec -it my-mysql bash

    # mysql -u root -p
    mysql> create database VISA_JAVA;
    mysql> use VISA_JAVA;
    mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, qty int);

    mysql> insert into products values (0, 'iPhone 16', 89000.00, 100);
    mysql> insert into products values (0, 'Sony Bravia', 214000.00, 100);
    mysql> insert into products values (0, 'Wacom', 5000.00, 100);
    
```