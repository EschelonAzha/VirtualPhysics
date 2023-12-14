package symmetrical.cosmic._physics._subatomic.bosons

interface IEmitter {
    fun absorb    (photon: Photon)      : Photon
    fun emit      ()                    : Photon
}