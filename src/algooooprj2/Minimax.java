//package algooooprj2;
//
//import javafx.scene.control.Label;
//
//public class Minimax {
//
//    public static int[] findBestMove(advanceScene game) {
//        int bestVal = Integer.MIN_VALUE;
//        int[] bestMove = new int[]{-1, -1};
//
//        for (Label label : game.labelList) {
//            String id = label.getId();
//            if (id != null && id.matches("L\\d+")) {
//                int row = Character.getNumericValue(id.charAt(1)) - 1;
//                int col = Character.getNumericValue(id.charAt(2)) - 1;
//
//                if (label.getText().equals("")) {
//                    label.setText(String.valueOf(game.c2));
//                    int moveVal = minimax(game, 0, false);
//                    label.setText("");
//
//                    if (moveVal > bestVal) {
//                        bestMove[0] = row;
//                        bestMove[1] = col;
//                        bestVal = moveVal;
//                    }
//                }
//            }
//        }
//
//        return bestMove;
//    }
//
//    private static int minimax(advanceScene game, int depth, boolean isMaximizing) {
//        int score = game.checkWinner();
//
//        if (score != 10) {
//            return score;
//        }
//
//        if (isMaximizing) {
//            int best = Integer.MIN_VALUE;
//            for (Label label : game.labelList) {
//                String id = label.getId();
//                if (id != null && id.matches("L\\d+")) {
//                    if (label.getText().equals("")) {
//                        label.setText(String.valueOf(game.c2));
//                        best = Math.max(best, minimax(game, depth + 1, !isMaximizing));
//                        label.setText("");
//                    }
//                }
//            }
//            return best;
//        } else {
//            int best = Integer.MAX_VALUE;
//            for (Label label : game.labelList) {
//                String id = label.getId();
//                if (id != null && id.matches("L\\d+")) {
//                    if (label.getText().equals("")) {
//                        label.setText(String.valueOf(game.c1));
//                        best = Math.min(best, minimax(game, depth + 1, !isMaximizing));
//                        label.setText("");
//                    }
//                }
//            }
//            return best;
//        }
//    }
//
//    public static void performAiMove(advanceScene game) {
//        int[] bestMove = findBestMove(game);
//
//        if (bestMove[0] != -1 && bestMove[1] != -1) {
//            int index = bestMove[0] * 3 + bestMove[1];
//            Label label = game.labelList.get(index);
//            label.setText(String.valueOf(game.c2));
//        }
//
//        game.game(); // Check for the result after the AI move
//    }
//}