# Repositori amb exercicis resolts d'IT Academy
## BE Java - Mòdul 6 (POO)
### Nivell 3

A tenir en compte:

- He fet un disseny per a evitar que les dades dels pagaments (payment rates, mínims i màxims permesos i irpf) de cada empleat estiguin _hardcoded_. Ara, es poden introduir des de la "vista" (mètode Main), i s'emmagatzemem al repositori (en un map).
- Totes les dades dels salaris (payment rates, mínim i màxim permesos i irpf) per a cada empleat, s'encapsulen a la classe PaymentData.
- He afegit la classe SalariesController, que és la que usem per a guardar les dades de pagament al repositori.
- La classe JobsController ara fa el control (amb excepcions) de la validesa dels salaris introduits en crear una instància d'empleat, ja que cal accedir al repositori per a obtenir les dades dels pagaments (rates, mínims i màxims i irpf) i no podem permetre que aquesta validació se segueixi fent dels dels contructors dels empleats, ja que de fer-ho així tindríem un acoblament classes de domain amb persistència, i això s'ha d'evitar.
- He eliminat la classe PaymentFactory, perquè en fer ús d'una interfície funcional (IPaymentRate) es pot simplificar tot el codi refactoritzant substituint aquesta classe (PaymentFactory) per l'ús de lambdes. El codi queda més net i clar.
