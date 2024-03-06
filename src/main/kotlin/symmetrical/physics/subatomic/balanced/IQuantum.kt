package symmetrical.physics.subatomic.balanced

import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

interface IQuantum {

    fun getQuantum()                  : IQuantum?
    fun getQuantumProton()            : Proton?
    fun getQuantumRoot()              : IQuantum
    fun setQuantum(quantum:IQuantum)  : IQuantum

}