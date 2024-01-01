package symmetrical.cosmic._physics._subatomic.bosons
/*
https://en.wikipedia.org/wiki/Emission_spectrum
 */
interface IEmitter {
    fun absorb    (photon: Photon)      : Photon
    fun emit      ()                    : Photon
}