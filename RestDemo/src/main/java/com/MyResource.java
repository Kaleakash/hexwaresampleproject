package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.*;
import java.util.*;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("obj")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "<h1>Got it!</h1>";
    }
    
   @GET
    @Path("xml")
    @Produces(MediaType.TEXT_XML)
    public String getXML() {
        return "<h1>Got it!</h1>";
    }

   @GET
    @Path("html")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<h1>Got it!</h1>";
    }

@GET
    @Path("queryParam")
    @Produces(MediaType.TEXT_PLAIN)
    public String displayName(@QueryParam("name") String empname) {
        return "Welcome "+empname;
    }

@GET
    @Path("pathParam/{fname}/{lname}")
    @Produces(MediaType.TEXT_PLAIN)
    public String displayFullName(@PathParam("fname") String fname, @PathParam("lname") String lname) {
        return "Welcome "+fname +", "+lname;
    }

@POST
    @Path("pathParamPost/{fname}/{lname}")
    @Produces(MediaType.TEXT_PLAIN)
    public String postPathParam(@PathParam("fname") String fname, @PathParam("lname") String lname) {
      	System.out.println("Post method");
	System.out.println("Name is "+fname);
	System.out.println("LName is "+lname);
	  return "Welcome "+fname +", "+lname;
    }

   @GET
   @Path("empPlain") 
   @Produces(MediaType.TEXT_PLAIN)  
   public String getEmpText(@QueryParam("id") int id, 
    @QueryParam("name") String name, @QueryParam("salary") float salary) {
      Emp emp = new Emp();
    emp.setId(id);
    emp.setName("Mr "+name);
    emp.setSalary(salary+2000);
   return "Id is "+emp.getId()+" Name is "+emp.getName()+" Salary is "+emp.getSalary();
  }  
  @GET
   @Path("empJson") 
   @Produces(MediaType.APPLICATION_JSON)  
   public Emp getEmpJson(@QueryParam("id") int id, 
    @QueryParam("name") String name, @QueryParam("salary") float salary) {
      Emp emp = new Emp();
    emp.setId(id);
    emp.setName("Mr "+name);
    emp.setSalary(salary+2000);
   return emp;
  }
@GET
   @Path("getEmp") 
   @Produces(MediaType.APPLICATION_JSON)  
   public Emp getEmp() {
      Emp emp = new Emp();
    emp.setId(100);
    emp.setName("Raj");
    emp.setSalary(12000);
   return emp;
  }

@GET
   @Path("getEmps") 
   @Produces(MediaType.APPLICATION_JSON)  
   public List<Emp> getEmps() {
      Emp e1 = new Emp();e1.setId(101);e1.setName("Raj");e1.setSalary(12000);
      Emp e2 = new Emp();e2.setId(102);e2.setName("Raju");e2.setSalary(14000);
     Emp e3= new Emp();e3.setId(103);e3.setName("Ravi");e3.setSalary(16000);
     Emp e4 = new Emp();e4.setId(104);e4.setName("Ram");e4.setSalary(18000);
    ArrayList<Emp> al =new ArrayList<Emp>();
   al.add(e1);al.add(e2);al.add(e3);al.add(e4);
   return al;
  }
@GET
   @Path("JsonOrXml") 
   @Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})  
   public Emp getEmpJsonAndXml(@QueryParam("id") int id, 
    @QueryParam("name") String name, @QueryParam("salary") float salary) {
      Emp emp = new Emp();
    emp.setId(id);
    emp.setName("Mr "+name);
    emp.setSalary(salary+2000);
   return emp;
  }

  
  @POST
   @Path("postData") 
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 
  @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public Emp postDataVerify(Emp emp) {
      	return emp;
  }

   @PUT
   @Path("putJson") 
   @Produces(MediaType.APPLICATION_JSON) 
   @Consumes(MediaType.APPLICATION_JSON) 
   public Emp putEmpJson(Emp emp) {
   emp.setSalary(emp.getSalary()+500);
   return emp;
  }

  @DELETE
   @Path("deleteJson/{id}") 
   @Produces(MediaType.TEXT_PLAIN)
    public String deleteEmp(@PathParam("id") int id) {
      Emp e1 = new Emp();e1.setId(101);e1.setName("Raj");e1.setSalary(12000);
      Emp e2 = new Emp();e2.setId(102);e2.setName("Raju");e2.setSalary(14000);
     Emp e3= new Emp();e3.setId(103);e3.setName("Ravi");e3.setSalary(16000);
     Emp e4 = new Emp();e4.setId(104);e4.setName("Ram");e4.setSalary(18000);
    ArrayList<Emp> al =new ArrayList<Emp>();
   al.add(e1);al.add(e2);al.add(e3);al.add(e4);
	int flag=0;
  	Iterator<Emp> ii = al.iterator();
	while(ii.hasNext()){
		Emp emp = ii.next();
		if(emp.getId()==id) {
			ii.remove();
			flag=1;
		}
	}
 	if(flag>0) {
		return "Record deleted successfully";
	}else {
		return "Record is not present";
	}	  
 
   }   
}