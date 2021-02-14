package com.coffeemachine.model;

public class SoldItemsEntity {

    private String soldItemName;

    /**
     * @param soldItemName
     *            the soldItemName to set
     * 
     * @return the SoldItemsEntity
     */
    public SoldItemsEntity(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    /**
     * @return the soldItemName
     */
    public String getSoldItemName() {
        return soldItemName;
    }

    /**
     * @param soldItemName
     *            the soldItemName to set
     */
    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (soldItemName == null ? 0 : soldItemName.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SoldItemsEntity)) {
            return false;
        }
        SoldItemsEntity other = (SoldItemsEntity) obj;
        if (soldItemName == null) {
            if (other.soldItemName != null) {
                return false;
            }
        } else if (!soldItemName.equals(other.soldItemName)) {
            return false;
        }
        return true;
    }

}
