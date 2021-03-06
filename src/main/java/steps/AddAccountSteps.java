package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.AccCreateMsgPage;
import pageObjects.AddAccountPage;
import pageObjects.HomePage;
import util.AlertClass;

public class AddAccountSteps {
    AddAccountPage objAddAccount;
    HomePage objHome;
    AccCreateMsgPage objAccCreateMsg;
    
    public AddAccountSteps(WebDriver driver) {
        objAddAccount = PageFactory.initElements(driver, AddAccountPage.class);
        objHome = PageFactory.initElements(driver, HomePage.class);
        objAccCreateMsg = PageFactory.initElements(driver, AccCreateMsgPage.class);
    }
    
    public void access() {
        objHome.clickNewAccountLink();
    }
    
    public void submit(String id, String type, String amount) {
        objAddAccount.setId(id);
        objAddAccount.clickIdLabel();
        
        objAddAccount.setType(type);
        
        objAddAccount.setInit(amount);        
        objAddAccount.clickIdLabel();
        
        objAddAccount.submitBtnClick();
    }
    
    public void clickWithData(String id, String amount) {
        objAddAccount.setId(id);
        objAddAccount.clickIdLabel();
        
        objAddAccount.setInit(amount);
        objAddAccount.clickIdLabel();
    }
    
    public String[] getResultTable() {
        return new String[] {objAccCreateMsg.getMsg(), objAccCreateMsg.getAccId(),objAccCreateMsg.getCusId(), objAccCreateMsg.getName(), objAccCreateMsg.getEmail(), objAccCreateMsg.getType(), objAccCreateMsg.getDate(), objAccCreateMsg.getAmount()};
    }
    
    public String[] getInvalidDataMsg() {
        return new String[] {objAddAccount.getIdMsg(), objAddAccount.getAmountMsg()};
    }
    
    public String getAlertMsg(WebDriver driver) {
        return AlertClass.getMsgAccept(driver);
    }
    
}
