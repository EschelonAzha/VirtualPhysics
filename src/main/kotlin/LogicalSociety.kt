
import asymmetrical.wormholes.pulsar.Pulsar
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.cosmology.INebula
import symmetrical.dom.Dom
import symmetrical.dom.properties.region.DomHeight
import websites.logical_society.LogicalSocietyGalaxy
import websites.logical_society.LogicalSocietyNebula
import kotlin.reflect.KClass

fun main(args: Array<String>) {
    Absorber.initialize()    // <######### FIRST!!!!!!

    simpleEmissionTest()
    testEmissions()
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
    atom1.capacitor_(atom2).capacitor(atom3)
    val pair: TauAntiTauPair = atom3.setCurrentValue("newValue")
    val pair2: TauAntiTauPair = atom1.setCurrentValue("jumby")

    val atom1Val1 = atom1.getCurrentValue()
    val atom2Val1 = atom2.getCurrentValue()
    val atom3Val1 = atom3.getCurrentValue()


    return;
}
fun testEmissions() {
    val property = DomHeight(99999999)
    val child = Dom()
    val parent = Dom()
    parent.addProperty(property)
    parent.append(child)

    val emission = parent.emit().radiate()

    val (emitter, remainder) = Absorber.materialize(emission)

    val clone:Dom = emitter as Dom
    return
}

fun simpleEmissionTest() {
    val atom = Atom("Hello World")
    val emission = atom.emit().radiate()

    val (clone, remainder) = Absorber.materialize(emission)

    return
}


