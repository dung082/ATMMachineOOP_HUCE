package Model;


public class TaiKhoan {
    String tk;
    String mk;
    String quyen;

    public TaiKhoan() {
    }

    
    public TaiKhoan(String tk, String mk,String quyen) {
        this.tk = tk;
        this.mk = mk;
        this.quyen = quyen;
    }
    
    public String getTaiKhoan(){
        return this.tk;
    }
    
    public void setTaiKhoan(String tk){
        this.tk = tk;
    }
    public String getMatKhau(){
        return this.mk;
    }
    
    public void setMatKhau(String mk){
        this.mk = mk;
    }
    
        public String getQuyen(){
        return this.quyen;
    }
    
    public void setQuyen(String quyen){
        this.quyen = quyen;
    }
    
}
