# HospitalVizsgaremekKovacsBalazs
Hospital Vizsgaremek

-Az alkalmazás egy kórház felépítését hivatott szimulálni ahol vannak Orvosok, Betegek és Receptek
-Az Orvosoknak lehet több Betegje de a Betegeknek csak 1 orvosa lehet, illetve a Betegek rendelkeznek 1 Recepttel is


-A dockeres konténerizációhoz először a docker_build.bat-ot majd a docker_run.bat-ot kell elindítani (Linuxson pedig a .sh végződésűeket)
-Mellékeltem a teszteléshez egy Postman collectiont is azt érdemes beimportálni


-Ami a teszteket illeti: nem tudtam unit teszteket írni egyet sem, integration tesztből is csak a Receipt osztályra sikerült talán