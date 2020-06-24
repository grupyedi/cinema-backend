package com.grupyedi.webservice.datastructures;

public class Edge{

    private int dest;
    private int source;
    private double weight;

    public Edge(int source, int dest){
        this(source, dest, 1.0);
    }

    public Edge(int source, int dest, double weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Edge))
            return false;

        Edge otherEdge = (Edge) o;

        return (this.dest == otherEdge.dest && this.source == otherEdge.source);
    }

    public int getDest(){
        return dest;
    }

    public int getSource(){
        return source;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public int hashCode(){
        int hash = 5;

        hash = 31 * hash + dest;
        hash = 31 * hash + source;

        return hash;
    }

    @Override
    public String toString(){
        return String.format("Edge[source=%d, dest=%d, weight=%f]", source, dest, weight);
    }
}
