package com.ydz.fuckings.business.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 订单model
* @ClassName: Order 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xieh 
* @date 2017年6月13日 下午3:50:08 
*
 */
public class Order implements Serializable {
	
	/**主键*/
    private Integer id;
    /**订单编号*/
    private String orderNbr;
    /**产品ID*/
    private Integer productId;
    /**城市ID*/
    private Integer cityId;
    /**详细地址*/
    private String addr;
    /**房屋面积*/
    private String floorSpace;
    /**备注*/
    private String remark;
    /**名字*/
    private String name;
    /**手机号*/
    private String phone;
    /**状态*/
    private String state;
    /**创建时间*/
    private Date createDate;
    /**区域*/
    private String mergerName;
    
    
    private static final long serialVersionUID = 1L;

    public String getMergerName() {
		return mergerName;
	}

	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}

	public String getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNbr(String orderNbr) {
		this.orderNbr = orderNbr;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getFloorSpace() {
        return floorSpace;
    }

    public void setFloorSpace(String floorSpace) {
        this.floorSpace = floorSpace == null ? null : floorSpace.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cityId=").append(cityId);
        sb.append(", addr=").append(addr);
        sb.append(", floorSpace=").append(floorSpace);
        sb.append(", remark=").append(remark);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", state=").append(state);
        sb.append(", createDate=").append(createDate);
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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getAddr() == null ? other.getAddr() == null : this.getAddr().equals(other.getAddr()))
            && (this.getFloorSpace() == null ? other.getFloorSpace() == null : this.getFloorSpace().equals(other.getFloorSpace()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getAddr() == null) ? 0 : getAddr().hashCode());
        result = prime * result + ((getFloorSpace() == null) ? 0 : getFloorSpace().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }
}