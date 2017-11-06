package com.ydz.fuckings.business.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品po
* @ClassName: Product 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月7日 下午5:44:15 
*
 */
public class Product implements Serializable {
	
    private Integer id;

    private String productNbr;

    private String productName;

    private Double productPrice;

    private String productClassId;

    private String img;

    private String imgs;

    private Date createDate;

    private String state;

    private String states;

    private String productDesc;
    
    private String className;
    
    private static final long serialVersionUID = 1L;

    public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNbr() {
        return productNbr;
    }

    public void setProductNbr(String productNbr) {
        this.productNbr = productNbr == null ? null : productNbr.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(String productClassId) {
        this.productClassId = productClassId == null ? null : productClassId.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states == null ? null : states.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productNbr=").append(productNbr);
        sb.append(", productName=").append(productName);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", productClassId=").append(productClassId);
        sb.append(", img=").append(img);
        sb.append(", imgs=").append(imgs);
        sb.append(", createDate=").append(createDate);
        sb.append(", state=").append(state);
        sb.append(", states=").append(states);
        sb.append(", productDesc=").append(productDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductNbr() == null ? other.getProductNbr() == null : this.getProductNbr().equals(other.getProductNbr()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getProductClassId() == null ? other.getProductClassId() == null : this.getProductClassId().equals(other.getProductClassId()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getImgs() == null ? other.getImgs() == null : this.getImgs().equals(other.getImgs()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getStates() == null ? other.getStates() == null : this.getStates().equals(other.getStates()))
            && (this.getProductDesc() == null ? other.getProductDesc() == null : this.getProductDesc().equals(other.getProductDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductNbr() == null) ? 0 : getProductNbr().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getProductClassId() == null) ? 0 : getProductClassId().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getImgs() == null) ? 0 : getImgs().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getStates() == null) ? 0 : getStates().hashCode());
        result = prime * result + ((getProductDesc() == null) ? 0 : getProductDesc().hashCode());
        return result;
    }
}