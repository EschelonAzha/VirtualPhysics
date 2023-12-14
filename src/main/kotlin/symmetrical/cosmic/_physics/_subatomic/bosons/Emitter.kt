package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic._physics._subatomic.bosons.Photon

interface Emitter {
    fun absorb    (photon: Photon)      : Photon
    fun emit      ()                    : Photon
}