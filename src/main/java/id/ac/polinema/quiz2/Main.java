package id.ac.polinema.quiz2;

import java.util.ArrayList;
import java.util.List;
/**
 * Tempat bebas untuk mencoba programmu. Kelas ini TIDAK dinilai.
 *
 * Ide percobaan (tulis sendiri setelah tiap tahap selesai):
 *  1. Buat satu Passenger, lalu coba ubah namanya.
 *  2. Buat satu BikeRide dan satu CarRide, lalu tampilkan tarif-nya.
 *  3. Masukkan keduanya ke RideCalculator.totalFare(...) lewat sebuah List.
 *  4. Buat RideDispatcher dengan new CashPayment(), tambahkan perjalanan, lalu panggil checkout(...).
 *
 * Jalankan lewat NetBeans (Run Project), VS Code (Run di atas main),
 * atau terminal: mvn -q compile exec:java
 */
public class Main {

    public static void main(String[] args) {
        
        Passenger passenger = new Passenger("P1", "Elsa");

        Ride bike = new BikeRide("L1", passenger, 5);
        Ride car = new CarRide("L2", passenger, 5);

        // Ongkos masing-masing perjalanan
        System.out.println("Perjalanan sepeda motor: ongkos " + bike.calculateFare());
        System.out.println("Perjalanan mobil: ongkos " + car.calculateFare() + ", biaya asuransi " + ((Insurable) car).insuranceFee());

        // Jumlah kedua tarif lewat RideCalculator
        List<Ride> rides = new ArrayList<>();
        rides.add(bike);
        rides.add(car);
        System.out.println("Jumlah kedua tarif: " + RideCalculator.totalFare(rides));
        System.out.println("Total asuransi: " + RideCalculator.totalInsurance(rides));

        // Checkout lewat RideDispatcher dengan CashPayment
        RideDispatcher dispatcher = new RideDispatcher(new CashPayment());
        dispatcher.add(bike);
        dispatcher.add(car);
        dispatcher.checkout("L1");   // Payment L1: Rp 12500.0
    }
}