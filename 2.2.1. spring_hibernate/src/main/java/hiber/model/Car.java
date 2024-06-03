package hiber.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne (mappedBy = "empCar")  //(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private  User empUser;


    public  Car(){}

    public Car (String model, int series, User empUser) {
        this.model = model;
        this.series = series;
        this.empUser = empUser;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(id, car.id) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, series);
    }

    @Override
    public String toString() {

        return "Auto [" +
                //"id: " + id +
                "model: '" + model + '\'' +
                ", series: " + series +
                ']';


        //return String.format ("Car [ model: %s, series: %d ]", id, model, series);
    }

}
