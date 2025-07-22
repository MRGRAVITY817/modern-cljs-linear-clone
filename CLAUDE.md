# Linear Clone - ClojureScript Project

This project is a Linear app clone built with ClojureScript, HSX, and RFX, focusing on issue management functionality.

## Technology Stack

- **ClojureScript** - Core language
- **Shadow CLJS** - Build tool
- **HSX** - Modern React 19 compatible UI library (alternative to Reagent)
- **RFX** - State management (alternative to Re-frame)
- **Datascript** - Client-side database
- **Untitled UI** - Component library
- **Tailwind CSS** - Styling framework

## Project Structure

This is an early-stage project focusing on issue management features including creating, viewing (table/kanban), editing, and deleting issues.

## Development Commands

Since this is a ClojureScript project with Shadow CLJS, common commands would likely include:

```bash
# Start development server
npx shadow-cljs watch app

# Build for production
npx shadow-cljs release app

# REPL
npx shadow-cljs cljs-repl app

# Run tests
npx shadow-cljs compile test
```

## Code Conventions

- Use ClojureScript idioms and naming conventions
- Follow HSX patterns for React components
- Use RFX for state management patterns
- Leverage Datascript for data queries and persistence
- Apply Tailwind classes for styling

## Architecture Notes

- **Frontend-only**: Client-side application with Datascript for persistence
- **Component-based**: HSX components following React patterns
- **Reactive**: RFX handles state management and reactivity
- **Data-driven**: Datascript provides normalized data storage and querying

## Key Files to Watch

When developing, pay attention to:
- Shadow CLJS configuration files
- HSX component definitions
- RFX event handlers and subscriptions
- Datascript schema and queries
- Tailwind configuration

## Testing

Test ClojureScript code using standard ClojureScript testing patterns with Shadow CLJS test runner.