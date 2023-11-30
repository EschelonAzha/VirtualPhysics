
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

    println("Start="+System.currentTimeMillis())
    for (i in 0 until 1) {
        test()
    }
    println("Stop ="+System.currentTimeMillis())

    Pulsar(LogicalSocietyGalaxy(), 9090, LogicalSocietyNebula::class as KClass<INebula>).start()
    println("Server Started on Port:9090 ...")
}







