package src.java_solutions;

public class MinimumPenaltyForAShop {

    /**
     * 2483. Minimum Penalty for a Shop
     * You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
     * <p>
     * if the ith character is 'Y', it means that customers come at the ith hour
     * whereas 'N' indicates that no customers come at the ith hour.
     * <p>
     * If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
     * <p>
     * For every hour when the shop is open and no customers come, the penalty increases by 1.
     * For every hour when the shop is closed and customers come, the penalty increases by 1.
     * <p>
     * Return the earliest hour at which the shop must be closed to incur a minimum penalty.
     * <p>
     * Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
     */

    class Solution {
        public int bestClosingTime(String customers) {
            int penaltyAtPrevIndex = 0;
            int minPenalty = 0;
            int minPenaltyIndex = 0;

            for (int index = 0; index < customers.length(); index++){
                int penaltyAtCurrentIndex = penaltyAtPrevIndex;
                if (customers.charAt(index) == 'Y'){
                    penaltyAtCurrentIndex--;
                } else {
                    penaltyAtCurrentIndex++;
                }
                if (penaltyAtCurrentIndex < minPenalty){
                    minPenalty = penaltyAtCurrentIndex;
                    minPenaltyIndex = index + 1;
                }
                penaltyAtPrevIndex = penaltyAtCurrentIndex;
            }

            return minPenaltyIndex;
        }
    }
}