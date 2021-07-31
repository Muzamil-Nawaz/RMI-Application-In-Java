package TestRMI;



public class Container {
    String containerId;
    String containerType,destination,deptTime,deptDate,carrier,containerColor;
    float length,width,height,weight;
    Container(){
        
    }
    public void setContainerId(String id){
        this.containerId = id;
    }
    public void setContainerType(String type){
        this.containerType = type;
    }
    public void setContainerDest(String dest){
        this.destination = dest;
    }
    public void setContainerColor(String color){
        this.containerColor = color;
    }
    public void setLength(float length){
        this.length = length;
    }
    public void setWidth(float width){
        this.width = width;
    }
    public void setHeight(float height){
        this.height = height;
    }
    public void setWeight(float weight){
        this.weight = weight;
    }
    public void setCarrier(String carrier){
        this.carrier = carrier;
    }
    public void setDeptTime(String time){
        this.deptTime = time;
    }
    public void setDeptDate(String date){
        this.deptDate = date;
    }
    public String getContainerId(){
        return containerId;
    }
    public String getContainerType(){
        return containerType;
    }
    public String getDestination(){
        return destination;
    }
    public String getDeptTime(){
        return deptTime;
    }
    public String getDeptDate(){
        return deptDate;
    }
    public String getCarrier(){
        return carrier;
    }
    public String getContainerColor(){
        return containerColor;
    }
    public float getLength(){
        return length;
    }
    public float getHeight(){
        return height;
    }
    public float getWidth(){
        return width;
    }
    public float getWeight(){
        return weight;
    }
    public String toString(){
        String s = "[Container Id:"+getContainerId()+",Container Type:"+getContainerType()+",Destination:"+getDestination()
                +",Departure Time:"+getDeptTime()+",Depature Date:"+getDeptDate()+",Carrier:"+getCarrier()
                +",Color:"+getContainerColor()+",Length:"+getLength()+",Height:"+getHeight()
                +",Width:"+getWidth()+",Weight:"+getWeight()+" ]";
        return s;
        
        
        
    }

    
  
    
}
