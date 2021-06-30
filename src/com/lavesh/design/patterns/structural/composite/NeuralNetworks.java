package com.lavesh.design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/12/18
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */


class Neuron implements Neurons{

    public ArrayList<Neuron> in, out;
    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }
}

interface Neurons extends Iterable<Neuron> {
      default void connectTo(Neurons other) {
              if (this == other)
                  return;

          for (Neuron from: this){
              for (Neuron to: other) {
                   from.out.add(to);
                  to.in.add(from);
              }
          }
      }
}

class NeuronLayer extends ArrayList<Neuron> implements Neurons { }



public class NeuralNetworks {
    public static void main(String[] args) {
        Neuron neuron1 = new Neuron();
        Neuron neuron2 = new Neuron();
        NeuronLayer neuronLayer1 = new NeuronLayer();
        NeuronLayer neuronLayer2 = new NeuronLayer();
        neuron1.connectTo(neuron2);
        neuron1.connectTo(neuronLayer2);
        neuron2.connectTo(neuronLayer1);
    }
}
