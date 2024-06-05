package hiber.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;


    @MapsId
    @OneToOne(mappedBy = "empCar")
    @JoinColumn(name = "empCar_id")
    private User empUser;

    public Car() {
    }

    public Car(String model, int series, User empUser) {
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

    public User getUser() {
        return empUser;
    }

    public void setUser(User empUser) {
        this.empUser = empUser;
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
                "id: " + id +
                ", model: '" + model + '\'' +
                ", series: " + series +
                ']';
    }

}
