package hiber.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "cars")
public class Car implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;


    @OneToOne(mappedBy = "useCar")

    private User carUser;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
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

    public User getCarUser() {
        return carUser;
    }

    public User setCarUser(User carUser) {
        this.carUser = carUser;
        return carUser;
    }


    @Override
    public String toString() {

        return "Auto [" +
                "id: " + id +
                ", model: '" + model + '\'' +
                ", series: " + series +
                ']';
    }

}
