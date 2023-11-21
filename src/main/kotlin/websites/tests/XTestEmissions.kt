package websites.tests

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

object XTestEmissions {

    @JvmStatic
    fun main(args: Array<String>) {
        debugQString()


        testParticle()
        testProton()
        testProtons()
        testNeutron()
        testNeutrons()
        testElectron()
        testOrbitals()
        testNucleons()
        testAtom()
        testQString()

        val emitter = Atom()
        emitter.setQuarkSpin(Spin())
        emitter.setQuarkValue(2022.22)
        emitter.setElectronSpin(Spin())
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

    private fun testParticle() {
        val particle = Particle().createUniqueId() as Particle
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }

    private fun testProton() {
        val particle = Proton().createUniqueId() as Particle
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }
    private fun testProtons() {
        val particle = Protons().createUniqueId() as Protons
        particle.addProton(Proton())
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }
    private fun testNeutron() {
        val particle = Neutron().createUniqueId() as Particle
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }

    private fun testNeutrons() {
        val particle = Neutrons().createUniqueId() as Neutrons
        particle.addNeutron(Neutron())
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }
    private fun testElectron() {
        val particle = Electron().createUniqueId() as Particle
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }
    private fun testOrbitals() {
        val particle = Orbitals().createUniqueId() as Orbitals
        particle.add(Electron())
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }

    private fun testNucleons() {
        val particle = Nucleons() as Nucleons
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }
    private fun testAtom() {
        val particle = Atom("Jumby")
        val emission = particle.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }
    private fun testQString() {
        val particle = QString("Jumby")
        particle.setString("Yuppy")
        val emission = particle.emit().radiate()
        val clone2 = Absorber.createInstance("dj") as QString
        clone2.setString("ooby")
        val (clone, remainder) = Absorber.materialize(emission)
        return
    }
    private fun debugQString() {
        val qString :QString = Absorber.createInstance("dj") as QString
        qString.setString("Jumby")
        return;
    }
}