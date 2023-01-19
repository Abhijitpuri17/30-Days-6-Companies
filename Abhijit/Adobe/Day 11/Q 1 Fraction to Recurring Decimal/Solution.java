class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }   
        
        StringBuilder sb = new StringBuilder();
        
        if(numerator*1L*denominator < 0){
            sb.append("-") ;
        }
        
        long num = Math.abs(numerator*1L);
        long den = Math.abs(denominator*1L);

        sb.append(num/den);
        
        num %= den;
        
        if(num == 0){
            return sb.toString() ;
        } 
        
        HashMap<Long,Integer> map = new HashMap<>();
        
        sb.append(".");
        
        while(num != 0){
            num *= 10;
            sb.append(num/den);
            num %= den;

            if(map.containsKey(num)){
                sb.insert(map.get(num),"(");
                sb.append(")");
                break;
            }
            else{
                map.put(num,sb.length());
            }
        }
        
        return sb.toString();
    }
    
}
