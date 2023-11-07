package symmetrical.cosmic._physics.atomic.atoms.orbitals

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics.atomic.atoms.Atom

interface IOrbitals {
    fun getElectronValue        ()              : Electron
    fun electronSpin            ()              : Boolean
    fun electronValue           ()              : Any?
    fun electronValueStr        ()              : String
    fun getClassId              ()              : String
    fun getElectronSpin         ()              : Spin
    fun getElectronWavelength   ()              : Any?
    fun getElectronPhoton       ()              : Photon
    fun setElectronSpin         (spin: Spin)    : Atom
    fun setElectronValue        (value:Any?)    : ZBoson
    fun setAtom                 (atom: Atom)    : Atom
}