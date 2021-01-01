package comp.packtpub.adfguide.ch9.view;

import javax.faces.event.ActionEvent;

public class BookMarkBean {
    private Integer departmentId=10;
    public BookMarkBean() {
    }

    public void test(ActionEvent actionEvent) {
        // Add event code here...
        throw new CustomViewExcpetion("Error");
    }
    public void initDept(){
        System.out.println("- initDept - ");
        
    }

    public void setDepartmentId(Integer departmentId) {
        System.out.println("-  deptId- " + departmentId);
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }
}
