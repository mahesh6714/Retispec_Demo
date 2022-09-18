package com.retispec.demo.AcquisitionModel;


import lombok.Builder;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "File_Data")
@Builder
public class Acquisitions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AcuqisitionId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    private String Eye;
    private String sitename;
    private Date DataTaken;
    private String OperatorName;
    private byte[] image;
    private String Filepath;

    public String getFilepath() {
        return Filepath;
    }

    public void setFilepath(String filepath) {
        Filepath = filepath;
    }

    public Acquisitions(int acuqisitionId, String eye, String sitename, Date dataTaken, String operatorName, byte[] image) {
        AcuqisitionId = acuqisitionId;
        Eye = eye;
        this.sitename = sitename;
        DataTaken = dataTaken;
        OperatorName = operatorName;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Acquisitions{" +
                "AcuqisitionId=" + AcuqisitionId +
                ", Eye='" + Eye + '\'' +
                ", sitename='" + sitename + '\'' +
                ", DataTaken=" + DataTaken +
                ", OperatorName='" + OperatorName + '\'' +
                ", image=" + image +
                '}';
    }

    public int getAcuqisitionId() {
        return AcuqisitionId;
    }

    public void setAcuqisitionId(int acuqisitionId) {
        AcuqisitionId = acuqisitionId;
    }

    public String getEye() {
        return Eye;
    }

    public void setEye(String eye) {
        Eye = eye;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public Date getDataTaken() {
        return DataTaken;
    }

    public void setDataTaken(Date dataTaken) {
        DataTaken = dataTaken;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
