package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class Mass {

    var mass: QuantumField = QuantumField()

    object Static {
            const val PHOTON        : Byte = 0
            const val NEUTRINO      : Byte = 1
            const val ELECTRON      : Byte = 2
            const val MUON          : Byte = 3
            const val TAU           : Byte = 4
            const val UP_QUARK      : Byte = 5
            const val DOWN_QUARK    : Byte = 6
            const val STRANGE_QUARK : Byte = 7
            const val CHARM_QUARK   : Byte = 8
            const val BOTTOM_QUARK  : Byte = 9
            const val TOP_QUARK     : Byte = 10
            const val PROTON        : Byte = 11
            const val NEUTRON       : Byte = 12
    }

    fun i() : Mass {
        return this
    }
}