package websites.tests

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.CRLFTerminatedSpin
import symmetrical.cosmic._physics.atomic.atoms.Atom

object XTestEmissions {

    @JvmStatic
    fun main(args: Array<String>) {

        val emitter = Atom()
        emitter.setQuarkSpin(CRLFTerminatedSpin())
        emitter.setQuarkValue(2022.22)
        emitter.setElectronSpin(CRLFTerminatedSpin())
        emitter.setElectronValue(33.33)
        val emission = emitter.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)

        return
//        val quark0   = (emitter as Protons).get(0) as Quark
//        quark0.getWavelength().setWavelength("!")
//
//        val quark1   = (emitter as Protons).get(1) as Quark
//        quark1.getWavelength().setWavelength("!!")
//
//        val quark2   = (emitter as Protons).get(2) as Quark
//        quark2.getWavelength().setWavelength("!!!")


//        val emission:String = emitter.emit()
//
//        val (classId, remainder) = Strings.remainder(2, emission)
//
//        val clone = Replicator.createInstance(classId) as Emitter
//        clone.absorb(remainder)

    }
}