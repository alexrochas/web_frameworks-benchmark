## How to contribute

#### **Adding new frameworks**

The main behavior a new framework must test is:

```gherkin
Given a framework
When receive 100.000 simultaneous hits
And acess the database to fetch 100 items
And filter those items with a query param
Then output report with successfull requests
```

In the long run, the idea is be more granular with the volume of tests (like 1.000, 10.000 and so on).

#### **How to generate report**

Using [Gatling](http://gatling.io).

In the simulations path you will find a very good start test (Coincidently called, *BasicSimulation.scala*). 
For now, all you have to do is run gatling pointing to the simulation folder.

```bash
~[PROJECT_HOME]$ $GATLING_HOME/bin/gatling.sh -sf ./simulation
```

A quick [read](http://alexrochas.github.io/general/2018/04/23/why-gatling.html) about it.

#### **Have an idea in how to improve the results?**

* Suggest your change in an issue, let's think about it together.

Thanks! :heart: :heart: :heart:

Alex
