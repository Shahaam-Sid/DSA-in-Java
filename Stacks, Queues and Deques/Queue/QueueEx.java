public class QueueEx {
    // P 6.36
    public static int ShareCalc(Queue<Shares> buysList, Shares sell) {
    int net = 0;
    int remainingToSell = sell.amount;
    
    while (remainingToSell > 0 && !buysList.isEmpty()) {
        Shares curr = buysList.dequeue();
        int sharesToSell = Math.min(curr.amount, remainingToSell);
        
        net += sharesToSell * (sell.valueEach - curr.valueEach);
        
        if (curr.amount > sharesToSell) {
            buysList.enqueue(new Shares(curr.amount - sharesToSell, 
                                       curr.valueEach, true));
        }
        
        remainingToSell -= sharesToSell;
    }
    return net;
}
    public static void main(String[] args) {
        QueueArray<Shares> qsh = new QueueArray<>(3);

        qsh.enqueue(new Shares(100, 20, true));
        qsh.enqueue(new Shares(20, 24, true));
        qsh.enqueue(new Shares(200, 36, true));

        Shares fshare = new Shares(150, 30, false);

        int n = ShareCalc(qsh, fshare);

        System.out.println(n);
    }
}
