
import asymmetrical.wormholes.pulsar.Pulsar
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.cosmology.INebula
import websites.logical_society.LogicalSocietyGalaxy
import websites.logical_society.LogicalSocietyNebula
import kotlin.reflect.KClass

fun main(args: Array<String>) {
    Absorber.initialize()    // <######### FIRST!!!!!!

    testDiodes()

    println("Start="+System.currentTimeMillis())
    for (i in 0 until 1) {
        test()
    }
    println("Stop ="+System.currentTimeMillis())

    Pulsar(LogicalSocietyGalaxy(), 9090, LogicalSocietyNebula::class as KClass<INebula>).start()
    println("Server Started on Port:9090 ...")
}

fun testDiodes() : Unit {
    val atom1: Atom = Atom("Atom1")
    val atom2: Atom = Atom("Atom2")
    val atom3: Atom = Atom("Atom3")
    atom1.diode_(atom2).diode(atom3)
    val pair: TauAntiTauPair = atom3.setCurrentValue("newValue")

    val atom1Val1 = atom1.getCurrentValue()
    val atom2Val1 = atom2.getCurrentValue()
    val atom3Val1 = atom3.getCurrentValue()


    return;
}